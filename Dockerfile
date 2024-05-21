FROM openjdk:17-jdk-alpine

# Set the working directory inside the container
WORKDIR /app

# Copy the JAR file generated by Maven/Gradle into the container
COPY target/*.jar app.jar

# Expose the port that the Spring Boot application will run on
EXPOSE 8081

# Command to run the Spring Boot application
CMD ["java", "-jar", "app.jar"]
