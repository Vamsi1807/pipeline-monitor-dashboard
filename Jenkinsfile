pipeline {

    agent any

    tools {
        jdk 'JDK17'
        maven 'Maven3'
        nodejs 'NodeJS'
    }

    stages {

        stage('Checkout') {
            steps {
                checkout scm
            }
        }
stage('Check Environment') {
    steps {
        sh 'java -version'
        sh 'echo JAVA_HOME=$JAVA_HOME'
        sh 'which java'
        sh 'ls -l /opt/java || true'
    }
}
        stage('Build Backend') {
            steps {

                dir('backend') {

                    sh 'chmod +x mvnw'

                    sh './mvnw clean package -DskipTests'

                }

            }
        }

        stage('Build Frontend') {
            steps {

                dir('frontend') {

                    sh 'npm install'

                    sh 'npm run build'

                }

            }
        }

        stage('Debug Variables') {
            steps {

                script {

                    echo "JOB_NAME     = ${env.JOB_NAME}"
                    echo "BUILD_NUMBER = ${env.BUILD_NUMBER}"
                    echo "BUILD_URL    = ${env.BUILD_URL}"
                    echo "GIT_BRANCH   = ${env.GIT_BRANCH}"
                    echo "GIT_COMMIT   = ${env.GIT_COMMIT}"

                }

            }
        }

    }

    post {

        success {

            script {

                def branch = (env.GIT_BRANCH ?: "main").replace("origin/", "")

                def buildUrl =
                        "http://host.docker.internal:8086/job/${env.JOB_NAME}/${env.BUILD_NUMBER}/"

                def consoleUrl =
                        "${buildUrl}console"

                sh """
                curl -X POST http://host.docker.internal:8080/api/builds \
                -H "Content-Type: application/json" \
                -d '{
                    "jobName":"${env.JOB_NAME}",
                    "buildNumber":${env.BUILD_NUMBER},
                    "status":"SUCCESS",
                    "duration":${currentBuild.duration},
                    "branch":"${branch}",
                    "commitId":"${env.GIT_COMMIT ?: ""}",
                    "buildUrl":"${buildUrl}",
                    "consoleUrl":"${consoleUrl}"
                }'
                """

            }

            archiveArtifacts artifacts: 'backend/target/*.jar',
                    fingerprint: true

            echo "Pipeline Monitor Build Successful"

        }

        failure {

            script {

                def branch = (env.GIT_BRANCH ?: "main").replace("origin/", "")

                def buildUrl =
                        "http://host.docker.internal:8086/job/${env.JOB_NAME}/${env.BUILD_NUMBER}/"

                def consoleUrl =
                        "${buildUrl}console"

                sh """
                curl -X POST http://host.docker.internal:8080/api/builds \
                -H "Content-Type: application/json" \
                -d '{
                    "jobName":"${env.JOB_NAME}",
                    "buildNumber":${env.BUILD_NUMBER},
                    "status":"FAILURE",
                    "duration":${currentBuild.duration},
                    "branch":"${branch}",
                    "commitId":"${env.GIT_COMMIT ?: ""}",
                    "buildUrl":"${buildUrl}",
                    "consoleUrl":"${consoleUrl}"
                }'
                """

            }

            echo "Pipeline Monitor Build Failed"

        }

        always {

            echo "Pipeline Finished"

        }

    }

}
