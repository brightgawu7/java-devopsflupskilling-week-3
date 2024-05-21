pipeline {
    agent any
    environment {
        DOCKER_IMAGE_TAG = "latest"
    }
    stages {
        stage('maven package') {
            steps {
                bat './mvnw clean package'
            }
        }
        stage('docker build') {
            steps {
                bat "docker build -t brightedem/app:${DOCKER_IMAGE_TAG} . "
            }
        }
        stage('docker push') {
            steps {
                script {
                    withDockerRegistry(credentialsId: 'dockerHub') {
                        bat "docker push brightedem/app:${DOCKER_IMAGE_TAG}"
                    }
                }
            }
        }
        stage('terraform init && validate') {
            steps {
                dir('./terraform') {
                    bat 'terraform init'
                    bat 'terraform validate'
                }
            }
        }
        stage('terraform apply') {
            steps {
                dir('./terraform') {
                    bat 'terraform apply -auto-approve'
                }
            }
        }
    }
    post {
        success {
            echo 'Everything works'
        }
        failure {
            script {
                currentBuild.result = 'FAILURE'
                echo 'Pipeline failed: ${currentBuild.result}'
                echo 'Details: Something went wrong'
            }
        }
    }
}
