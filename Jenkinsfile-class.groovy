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
        cf push -p build/libs/sunshine-forge-0.0.1-SNAPSHOT.jar
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
}