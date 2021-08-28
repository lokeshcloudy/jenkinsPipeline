def gv 
pipeline {
    agent any
    tools {
        maven 'maven'
    }
    stages {
        stage("init") {
            steps {
                script {
                    gv = load "script.groovy"
                }
            }
        }
        stage("test") {
            steps {
                script {
                    gv.buildApp('mvn package')
                }
            }
        }
        stage("DockerLogin") {
            steps {
                script {
                    gv.dockerLogin 'dockerhub'
                }
            }
        }
        stage("DockerBuild") {
            steps {
                script {
                    gv.dockerBuild 'lokeshlish/jar_application:1.0.0'
                }
            }
        }
        stage("DockerPush") {
            steps {
                script {
                    gv.dockerPush 'lokeshlish/jar_application:1.0.0'
                }
            }
        }
        stage("Deploy") {
            steps {
                script {
                    gv.deployApp()
                }
            }
        }
        
    }
}