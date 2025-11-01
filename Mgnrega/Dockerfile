# Use OpenJDK 17 base image
FROM openjdk:21-jdk-slim AS build

# Set working directory
WORKDIR /app

# Copy Maven project files
COPY pom.xml ./
COPY src ./src

# Package the application
RUN ./mvnw clean package -DskipTests

# Use a smaller image for runtime
FROM openjdk:21-jdk-slim
WORKDIR /app

# Copy jar file from build stage
COPY --from=build /app/target/*.jar app.jar

# Run the app
ENTRYPOINT ["java", "-jar", "app.jar"]
