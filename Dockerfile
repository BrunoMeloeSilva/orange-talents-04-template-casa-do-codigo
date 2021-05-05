FROM openjdk:11-jdk-oracle
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} casa-do-codigo.jar
ENTRYPOINT java -jar casa-do-codigo.jar