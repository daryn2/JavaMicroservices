FROM openjdk:8-jdk-alpine
VOLUME /tmp
EXPOSE 8082

ARG JAR_FILE=target/detailed-info-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} detailed-info.jar


ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/detailed-info.jar"]
