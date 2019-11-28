FROM openjdk:8-jdk-alpine
VOLUME /tmp
EXPOSE 8081

ARG JAR_FILE=target/car-catalog-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} car-catalog.jar


ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/car-catalog.jar"]
