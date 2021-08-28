pipeline {
    agent any
    tools {
        maven 'maven'
    }
    stages {
        stage("Build") {
            steps {
                script {
                    buildApp()
                }
            }
        }
        stage("DockerLogin") {
            steps {
                script {
                    dockerLogin()
                }
            }
        }
        stage("DockerBuild") {
            steps {
                script {
                    dockerBuild()
                }
            }
        }
        stage("DockerPush") {
            steps {
                script {
                    dockerPush()
                }
            }
        }
        stage("Deploy") {
            steps {
                script {
                    deployApp()
                }
            }
        }
        
    }
}