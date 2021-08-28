def buildApp() {
    echo 'Building the image.....'
    sh 'mvn package'
}

def dockerLogin() {
    echo 'Testing the Image'
    withCredentials([usernamePassword(credentialsId: 'dockerhub', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
        sh "echo ${PASS} | docker login -u ${USER} --password-stdin"

    }
}

def dockerBuild() {
    echo 'Building The Image....'
    sh 'docker build -t lokeshlish/jar_application:1.0.0. .'
}

def dockerPush() {
    echo 'Pushing The Docker Image'
    sh 'docker push lokeshlish/jar_application:1.0.0.'
}

def deployApp() {
    echo 'Deploying The Image'
}

return this