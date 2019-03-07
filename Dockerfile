FROM openjdk:8-jdk-alpine

VOLUME /tmp

ARG JAR_FILE=target/auth-server-0.0.1-SNAPSHOT.jar

ADD ${JAR_FILE} auth-server.jar

CMD ["java","-jar","/auth-server.jar"]