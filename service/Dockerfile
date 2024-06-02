# Use official OpenJDK image as the base image
FROM openjdk:11-jre-slim

# Set the working directory in the container
WORKDIR /app

# Copy the packaged Spring Boot application JAR file to the working directory
COPY target/openapi-spring-1.0.0-SNAPSHOT.jar .

# Command to run the Spring Boot application
CMD ["java", "-jar", "openapi-spring-1.0.0-SNAPSHOT.jar"]