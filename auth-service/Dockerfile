FROM openjdk:8-jdk-alpine
VOLUME /tmp
EXPOSE 9100

ARG JAR_FILE=target/auth-service-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} auth-service.jar


ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/auth-service.jar"]
