pipeline {
    agent any

    tools {
        maven 'Maven 3.9.11'     
        jdk 'jdk-17.0.3.1'            
    }

    environment {
        MAVEN_OPTS = "-Xmx1024m"
    }

    stages {
        stage('Checkout') {
            steps {
                echo 'Cloning project from Git...'
                git branch: 'main', url: 'https://github.com/akashv13/JenkinTarus.git'
            }
        }

        stage('Build') {
            steps {
                echo 'Running Maven Clean and Compile...'
                bat 'mvn clean compile'
            }
        }

        stage('Test') {
            steps {
                echo 'Running Unit Tests...'
                bat 'mvn test'
            }
        }

        stage('Package') {
            steps {
                echo 'Packaging the application...'
                bat 'mvn package'
            }
        }

        stage('Deploy (Optional)') {
            when {
                branch 'main'
            }
            steps {
                echo 'Deploying application...'
                // your deployment command here
            }
        }
    }

    post {
        always {
            echo 'Cleaning up...'
        }

        success {
            echo 'Build succeeded!'
        }

        failure {
            echo 'Build failed.'
        }
    }
}
