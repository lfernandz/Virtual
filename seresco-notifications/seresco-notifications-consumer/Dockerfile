FROM openjdk:8-jdk-alpine
ARG JAR_FILE="./target/seresco-notifications-consumer-0.0.1-SNAPSHOT.jar"
COPY ${JAR_FILE} seresco-notifications.jar
EXPOSE 35000
ENTRYPOINT ["java","-jar","/seresco-notifications.jar"]