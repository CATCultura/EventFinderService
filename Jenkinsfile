pipeline {
    agent any

    stages {
        
        stage('Analysis') {
            steps {
                sh '/home/alumne/sonar-scanner-4.7.0.2747-linux/bin/sonar-scanner -Dsonar.projectKey=EventFinderService -Dsonar.sources=. -Dsonar.host.url=http://10.4.41.41:9000 -Dsonar.login=sqp_19a4c0786f6352089c0cd6693ffaa5be6bc9f7b2'
            }
        }

        stage('Deploy') {
            steps {
                sh 'sudo docker build -t eventfinder .'
                sh 'sudo docker tag eventfinder catculturacontainerhub.azurecr.io/eventfinder'
                sh 'sudo docker push catculturacontainerhub.azurecr.io/eventfinder'
            }
        }
        stage('Notify') {
          steps {
            discordSend description: "Jenkins Pipeline Build", footer: "Service working OK", link: env.BUILD_URL, result: currentBuild.currentResult, title: JOB_NAME, webhookURL: "https://discord.com/api/webhooks/1029023402079572108/PSi21wQLj8EdmwAYw6DbyEsGuppRKibwV7r81QVq743lG5Z3_qZw2vNIr5jJ_sU_15RZ"
         }
        }

    }
}
