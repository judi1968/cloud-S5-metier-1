FROM openjdk:17.0.1-jdk-slim
ARG JAR_FILE=target/*jar
COPY ${JAR_FILE} app.jar
EXPLOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]