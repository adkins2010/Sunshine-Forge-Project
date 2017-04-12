#!/usr/bin/env groovy
def docker_registry

node {
    docker_registry = env.DOCKER_REGISTRY
    checkout scm
}

docker.image(docker_registry + "/compozed/ci-base:0.8").inside() {
    env.GRADLE_USER_HOME = "."
    stage("Build") {
        sh '''
      ./gradlew clean build
      '''
    }


    withCredentials([
            [
                    $class          : 'UsernamePasswordMultiBinding',
                    credentialsId   : 'c47a385f-6585-40c5-85ba-3cf2580e2776',
                    passwordVariable: 'CF_PASSWORD',
                    usernameVariable: 'CF_USERNAME'
            ]]) {

        stage("Deploy") {
            sh '''
        set -e +x
        cf login -a api.cf.nonprod-mpn.ro11.allstate.com -u ${CF_USERNAME} -p ${CF_PASSWORD} --skip-ssl-validation; cf target -o IS-COMPOZED-ACCELERATOR -s DEV
        cf push -p build/libs/sunshine-forge-1.0.${BUILD_NUMBER}.jar
        '''
        }
    }


    withCredentials([
            [
                    $class          : 'UsernamePasswordMultiBinding',
                    credentialsId   : 'c47a385f-6585-40c5-85ba-3cf2580e2776',
                    passwordVariable: 'ARTIFACTORY_PASSWORD',
                    usernameVariable: 'ARTIFACTORY_USERNAME'
            ]]) {
        stage("Publish to Artifactory") {
            sh '''
              set -e +x
              ./gradlew publish
            '''
        }
    }

    withCredentials([
            [
                    $class          : 'UsernamePasswordMultiBinding',
                    credentialsId   : 'c47a385f-6585-40c5-85ba-3cf2580e2776',
                    passwordVariable: 'CF_PASSWORD',
                    usernameVariable: 'CF_USERNAME'
            ]]) {
        stage("Deploy-UAT") {
            step([
                    $class: 'ConveyorJenkinsPlugin',
                    applicationName: 'sunshine-forge',
                    artifactURL: "https://artifactory.allstate.com/artifactory/libs-release-local/com/allstate/platform/eng/sunshine-forge-mike/1.0.${env.BUILD_NUMBER}/sunshine-forge-mike-1.0.${env.BUILD_NUMBER}.jar",
                    environment: 'non-prod',
                    manifest: """
                          applications:
                          - name: 'sunshine-forge-uat'
                            host: 'sunchine-forge-mike'
                            instances: 1
                            memory: 512M
                            buildpack: 'java_buildpack_offline'
                            env:
                              MY_ENV_VARIABLE: "Dummy"
                              """,
                    organization: 'IS-COMPOZED-ACCELERATOR',
                    space: 'UAT',
                    serviceNowGroup: 'XP_IS_CHG',
                    serviceNowUserID: env.CF_USERNAME,
                    username: env.CF_USERNAME,
                    password: env.CF_PASSWORD
            ])
        }
    }
}