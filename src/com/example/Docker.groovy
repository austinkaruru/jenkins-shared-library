#!/usr/bin/env groovy

package com.example

class Docker implements Serializable {
    def script

    Docker(script) {
        this.script = script
    }

    def buildDockerImage(String imageName) {
        script.echo "building the docker image...."
        script.withCredentials([usernamePassword(credentialsId: 'docker-hub-repo', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
            //sh 'docker build -t austinmwangi/docker-jenkins:2.0 .'
            script.sh "docker build -t $imageName ."
            script.sh "echo $script.PASS | docker login -u $script.USER --password-stdin"
            //sh 'docker push austinmwangi/docker-jenkins:2.0'
            script.sh "docker push $imageName"
        }

    }
}