# Use official OpenJDK 17 runtime as a base image
FROM eclipse-temurin:17-jdk-alpine

# Set working directory inside the container
WORKDIR /app

# Copy the built jar from target folder to the container
COPY target/*.jar app.jar

# Expose the port your Spring Boot app runs on (default 8080)
EXPOSE 9988

# Command to run the jar file
ENTRYPOINT ["java", "-jar", "app.jar"]