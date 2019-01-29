#!/usr/bin/env groovy
pipeline {
    agent { docker { image 'maven:3.6.0' } }
    stages {
        stage('version') {
//            docker.image.inside
            steps {
                sh 'mvn --version'
            }
        }
        stage('compile') {
            steps {
                sh 'mvn clean compile'
            }
        }
        stage('test') {
            steps {
                sh 'mvn clean test'
            }
        }

        stage('install') {
            steps {
                sh 'mvn clean install -X'
            }
        }
    }

}