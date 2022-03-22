pipeline {
    agent any

    stages {
        stage('clone') {
            steps {
                checkout([$class: 'GitSCM', branches: [[name: '*/master']], extensions: [], userRemoteConfigs: [[credentialsId: 'b9ccd6da-f1f5-4adb-a175-448d527a31f7', url: 'http://192.168.21.20:8000/root/devops-springboot.git']]])            }
        }
        stage('mvn package') {
            steps {
                sh label: '', script: 'mvn clean compile package install -Dmaven.test.skip=true'
            }
        }

        stage('mvn dockerfile') {
            steps {
                sh 'docker container rm -f devops-springboot'
                sh 'docker image ls | grep library | awk \'{print "docker image rm " $3}\' | bash '
                sh label: '', script: 'mvn dockerfile:build dockerfile:push'
                sh label: '', script: 'docker run -itd  -p 8888:8080 --name devops-springboot 192.168.21.20:85/library/devops-springboot:0.0.1-SNAPSHOT'

            }
        }
    }
}
