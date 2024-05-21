pipeline{
    agent any
       environment {
            DOCKER_IMAGE_TAG = "latest"
        }
    stages{

      
  
        

    stage('terraform init && validate'){
        
        dir('./terraform'){
           steps{
                   bat 'terraform init'
                   bat 'terraform validate'
               }
         }
    }
    
    
    stage('terraform apply'){
         
        dir('./terraform'){
            steps{
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
