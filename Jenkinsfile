def dockerComposeFile = 'docker-compose.yml'

pipeline{
    agent any
    stages{

  stage('bright'){
    steps{
        bat "terraform --version"
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
