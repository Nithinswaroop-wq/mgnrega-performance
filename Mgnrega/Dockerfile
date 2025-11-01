# Use OpenJDK 21 as base image
FROM openjdk:21-jdk-slim

# Set working directory inside container
WORKDIR /app

# Copy Maven wrapper and pom.xml first to leverage caching
COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .

# Download dependencies (helps caching)
RUN ./mvnw dependency:go-offline -B

# Copy the rest of the project files
COPY src ./src

# Package the application
RUN ./mvnw clean package -DskipTests

# Run the built jar file
CMD ["java", "-jar", "target/*.jar"]
