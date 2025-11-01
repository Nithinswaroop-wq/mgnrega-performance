# ================================
# Build stage
# ================================
FROM maven:3.9.6-eclipse-temurin-21 AS build

WORKDIR /app

# Copy pom.xml and source code
COPY pom.xml ./
COPY src ./src

# Package the app using system Maven
RUN mvn clean package -DskipTests


# ================================
# Run stage
# ================================
FROM eclipse-temurin:21-jdk-alpine

WORKDIR /app

# Copy built JAR from previous stage
COPY --from=build /app/target/*.jar app.jar

# Expose port 8080
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
