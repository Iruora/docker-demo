pipeline {
    agent any
    tools {
        maven 'Maven 3.3.9'
        jdk 'jdk8'
    }
    stages{
        stage("Init"){
            steps{
                sh '''
                    echo "PATH = ${PATH}"
                    echo "M2_HOME = ${M2_HOME}"
                '''
            }
        }
        stage("Build"){
            steps{
                sh '''
                    mvn package
                '''
            }
        }
    }
    post{
        success{
            echo "======== SUCCESSED ========"
        }
        failure{
            echo "======== FAILED ========"
        }
    }
}