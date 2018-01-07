pipeline {
  agent any

  stages {
    stage('Clean Compile') {
      steps {
        sh 'mvn clean compile -DskipTests'
      }
    }

        stage('Units Tests') {
          steps {
            sh 'mvn clean test'
          }
          post {
            success {
              junit 'target/surefire-reports/**/*.xml'
            }

          }
        }
    stage('SonarQube Scanner') {
      steps {
        script {
          withSonarQubeEnv('SonarQubeServer') {
            sh 'mvn clean install sonar:sonar -X -DskipTests'
          }
        }
        
      }
    }

    stage('Integration Tests') {
      steps {
        echo 'Jeux Campagne tests d\'intégration'
      }
    }
    stage('Functionnals Tests Phases') {
      parallel {
        stage('NR Tests') {
          steps {
            echo 'Jeux Campagne tests de Non regression'
          }
        }
        stage('Integration Tests') {
          steps {
            echo 'Jeux Campagne tests d\'intégration'
          }
        }
      }
    }
    stage('SonarQube Quality Gate') {
      steps {
        script {
          timeout(time: 10, unit: 'MINUTES') {
            def qg = waitForQualityGate()
            if (qg.status != 'OK') {
              error "Pipeline aborted due to quality gate failure: ${qg.status}"
            }else{
                manager.addShortText("QA-OK")
            }
          }
        }
      }
    }
  }
  tools {
    maven 'Maven_3.3.9'
  }
  post {
    always {
      steps() {
        sh 'mvn clean'
      }
    }
  }
  options {
    timeout(time: 30, unit: 'MINUTES')
  }
}