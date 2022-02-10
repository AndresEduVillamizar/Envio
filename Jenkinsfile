@Library('ceiba-jenkins-library')
pipeline {
  agent {
    label 'Slave_Induccion'
  }

  options {
    	buildDiscarder(logRotator(numToKeepStr: '3'))
 	disableConcurrentBuilds()
  }

  //Una sección que define las herramientas “preinstaladas” en Jenkins
  tools {
    jdk 'JDK8_Centos' //Verisión preinstalada en la Configuración del Master
  }

  stages{
     stage('Checkout') {
            steps {
                echo '------------>Checkout desde Git Microservicio<------------'
                checkout([
                    $class: 'GitSCM',
                    branches: [[name: '*/master']],
                    doGenerateSubmoduleConfigurations: false,
                    extensions: [],
                    gitTool: 'Default' ,
                    submoduleCfg: [],
                    userRemoteConfigs: [[credentialsId: 'GitHub_AndresEduVillamizar',
                        url: 'https://github.com/AndresEduVillamizar/Envio']]])
                }
        }
    
    	stage('Compile & Unit Tests') {
		steps{
			echo "------------>compile & Unit Tests<------------"
			sh 'chmod +x gradlew'
			sh './gradlew --b ./build.gradle clean'
			sh './gradlew --b ./build.gradle test'
		}
	}


    stage('Static Code Analysis') {
    		steps{
        		sonarqubeMasQualityGatesP(sonarKey:'co.com.ceiba.adn:proyectoADN.envio-eduardo.villamizar', 
        		sonarName:'CeibaADN-ProyectoADNEnvio(eduardo.villamizar)', 
        		sonarPathProperties:'./sonar-project.properties')
    		}
	} 


    stage('Build') {
		steps{
			echo "------------>Build<------------"
			//Construir sin tarea test que se ejecutó previamente
			sh './gradlew --b ./build.gradle build -x test'
	}
}
 
  }

  post {
    always {
      echo 'This will always run'
    }
    success {
	echo 'This will run only if successful'
	junit 'build/test-results/test/*.xml' //RUTA RELATIVA DE LOS ARCHIVOS .XML
	}

    failure {
	echo 'This will run only if failed'
	mail (to: 'eduardo.villamizar@ceiba.com.co',subject: "Failed Pipeline:${currentBuild.fullDisplayName}",body: "Something is wrong with ${env.BUILD_URL}")
	}

    unstable {
      echo 'This will run only if the run was marked as unstable'
    }
    changed {
      echo 'This will run only if the state of the Pipeline has changed'
      echo 'For example, if the Pipeline was previously failing but is now successful'
    }
  }
}
