FROM openjdk:8-jdk-alpine
VOLUME /tmp
EXPOSE 8081

ARG JAR_FILE=target/common-service-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} common-service.jar


ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/common-service.jar"]
