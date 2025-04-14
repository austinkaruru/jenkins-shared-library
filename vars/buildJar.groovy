#!/usr/bin/env groovy

def call() {
   // echo "building the application for branch $BRANCH_NAME"
    echo "building the application"
    sh 'mvn package'
}