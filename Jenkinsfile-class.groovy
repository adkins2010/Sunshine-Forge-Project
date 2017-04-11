#!/usr/bin/env groovy

node {
    checkout scm
    stage("Build") {
        env.GRADLE_USER_HOME="."
        sh '''
      ./gradlew clean build
      '''
    }
}