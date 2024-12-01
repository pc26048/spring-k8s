pipeline {
 agent any
 tools{
 	jdk 'JDK17'
 	maven 'MAVEN3'
 }

stages {
        stage('Checkout Code') {
            steps {
                echo 'Checking out code from Git repository...'
                checkout scm
            }
        }

        stage('Maven Compile') {
            steps {
                echo 'Compiling the project...'
                bat 'mvn clean compile'
            }
        }

        stage('Unit Test') {
            steps {
                echo 'Running unit tests...'
                bat 'mvn test'
            }
        }

        stage('Code Coverage') {
            steps {
                echo 'Generating Jacoco coverage report...'
                bat 'mvn jacoco:report'
            }
        }

        stage('Build Package') {
            steps {
                echo 'Packaging the application...'
                bat 'mvn package'
            }
        }

	stage('Docker Image') {
            steps {
                echo 'Build Docker Image'
                bat 'docker build -t praveen4321/spring-k8s-jenkins-img --build-arg VER=1.0 .'
            }
        }
        
        stage('Docker Push to DockerHub') {
            steps {
                echo 'Push Docker Image to DockerHub'
                bat 'docker push praveen4321/spring-k8s-jenkins-img'
            }
        }
        
        stage('Deploy to Kubernetes Cluster') {
            steps {
                echo 'Deploying application to Kubernetes cluster...'

             

                bat 'kubectl apply -f k8s-deployment.yaml'
				bat 'kubectl apply -f k8s-service.yaml'
                // Verify the deployment
                bat 'kubectl get pods'
                bat 'kubectl get svc'
            }
        }
        
        
    }
}