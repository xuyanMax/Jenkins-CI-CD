#!/usr/bin/env groovy
pipeline {
    agent { docker { image 'maven:3.3.9' } }
    stages {
        stage('version') {
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