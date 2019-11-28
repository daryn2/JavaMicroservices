FROM openjdk:8-jdk-alpine
VOLUME /tmp
EXPOSE 8762

ARG JAR_FILE=target/zuul-proxy-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} zuul-proxy.jar


ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/zuul-proxy.jar"]
