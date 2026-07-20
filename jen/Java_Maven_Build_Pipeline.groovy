pipeline{
    agent any

    tool{
        maven 'Maven 3.6.3'
        jdk 'JDK 21.0.1'
    }

    stages{
        stage('checkout'){
            steps{
                checkout scm
            }
        }

        stage('Build'){
            steps{
                sh 'mvn clean install'
            }
        }

        stage('Test'){
            steps{
                sh 'mvn test'
            }
        }

        stage('Deploy'){
            steps{
                sh 'mvn deploy'
            }
        }

        post{
            success{
                echo 'Build and deployment successful!'
            }
        }
        
    }
}