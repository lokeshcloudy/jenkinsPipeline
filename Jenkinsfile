pipeline {
    agent any
    tools {
        maven 'maven'
    }
    stages {
        stage("Build") {
            steps {
                script {
                    echo 'Building the image'
                    sh 'mvn package'
                }
            }
        }
        stage("DockerLogin") {
            steps {
                script {
                    echo 'Building the image'
                    withCredentials([usernamePassword(credentialsId: 'dockerhub', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
                        sh "echo ${PASS} | docker login -u ${USER} --password-stdin"
                    }
                }
            }
        }
        stage("DockerBuild") {
            steps {
                script {
                    echo 'Building the image'
                    sh 'docker build -t lokeshlish/java_app:1.0.0 .'
                }
            }
        }
        stage("DockerPush") {
            steps {
                script {
                    echo 'Building the image'
                    sh 'docker push lokeshlish/java_app:1.0.0'
                }
            }
        }
        stage("Deploy") {
            steps {
                script {
                    echo 'Deploying the mage'
                }
            }
        }
        
    }
}