# Use official OpenJDK image as the base image
FROM openjdk:11-jre-slim

ADD target/openapi-spring-1.0.0-SNAPSHOT.jar spring-app.jar
# Command to run the Spring Boot application
ENTRYPOINT ["java", "-jar", "spring-app.jar"]