def buildApp(String package) {
    echo 'Building the image'
    sh "${package}"
}

def dockerLogin(String id) {
    echo 'Testing the Image'
    withCredentials([usernamePassword(credentialsId: '${id}', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
        sh "echo ${PASS} | docker login -u ${USER} --password-stdin"

    }
}

def dockerBuild(String imageName) {
    echo 'Building The Image....'
    sh "docker build -t ${imageName} ."
}

def dockerPush(String imageName) {
    echo 'Pushing The Docker Image'
    sh "docker push ${imageName}"
}

def deployApp() {
    echo 'Deploying The Image'
}

return this