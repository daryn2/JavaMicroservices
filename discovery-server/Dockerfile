FROM openjdk:8-jdk-alpine
VOLUME /tmp
EXPOSE 8761

ARG JAR_FILE=target/discovery-server-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} discovery-server.jar


ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/discovery-server.jar"]
