#!/usr/bin/env groovy

def call(String imageName) {
    echo "Building the docker image"
    withCredentials([usernamePassword(credentialsId: 'docker-hub-repo', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
        //sh 'docker build -t austinmwangi/docker-jenkins:2.0 .'
        sh "docker build -t $imageName ."
        sh "echo $PASS | docker login -u $USER --password-stdin"
        //sh 'docker push austinmwangi/docker-jenkins:2.0'
        sh "docker push $imageName"
    }
}

