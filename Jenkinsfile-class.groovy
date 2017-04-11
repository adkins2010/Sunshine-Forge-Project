#!/usr/bin/env groovy
def docker_registry

node {
    docker_registry = env.DOCKER_REGISTRY
    checkout scm
}

docker.image(docker_registry + "/compozed/ci-base:0.8").inside() {
    env.GRADLE_USER_HOME="."
    stage("Build") {
        sh '''
      ./gradlew clean build
      '''
    }
}