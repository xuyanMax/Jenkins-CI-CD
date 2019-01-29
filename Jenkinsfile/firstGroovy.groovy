#!/usr/bin/env groovy
pipeline {
    agent { docker { image 'maven:3.3.3' } }
    stages {
        stage('version') {
            steps {
                sh 'mvn --version'
            }
        }
    }
    stages {
        stage('compile') {
            steps {
                sh 'mvn clean compile'
            }
        }
    }
    stages {
        stage('test') {
            steps {
                sh 'mvn test'
            }
        }
    }
    stages {
        stage('install') {
            steps {
                sh 'mvn install'
            }
        }
    }
}