pipeline {
    agent any
    
    environment {
        
        dockerImage = ''
        registry = "harsh8848/springboot-jenkins-demo"
        registryCredential = '50bdcf62-5759-4334-b661-a7fd2b19887b'
        //dockerImage = ''
    }
   

    stages {
        stage('Build') {
            steps {
              
               // bat 'mvn -Dmaven.test.failure.ignore=true clean' 
                bat 'mvn compile' 
                echo 'Compiling Project....'
                echo 'Compiled Successfully'
            }
        }
       // stage('Test') {
         //   steps {
           //     bat 'mvn test'
             //   echo 'Testing.....'
              //  echo 'Tested Successfully'
           // }
        //}
        
//           stage('Packaging') {
//             steps {
//                 bat 'mvn package'
//                 echo 'Packaging.....'
//                 echo 'JAR file  Successfully created'
//             }
//         }
        
        
       // docker build . -t app-springboot
        
       stage('Building image') {
            steps{
                script {
                     dockerImage = docker.build registry
                }
            }
        }
        
        
        stage('Deploy Image') {
             steps{
                script {
                    docker.withRegistry( '', registryCredential ) {
                    dockerImage.push("$BUILD_NUMBER")
                    dockerImage.push('latest')
                     }
                 }
             }
         }
    }
}
