 # Use OpenJDK 21 as base image
 FROM openjdk:21-jdk-slim

 # Set working directory inside container
 WORKDIR /app

 # Copy Maven wrapper and pom.xml first to leverage caching
 COPY mvnw .
 COPY .mvn .mvn
 COPY pom.xml ./

 # Download dependencies (helps caching)
 RUN chmod +x mvnw && ./mvnw dependency:go-offline -B

 # Copy the rest of the project files
 COPY src ./src

 # Package the application
 RUN ./mvnw clean package -DskipTests

 # Expose port
 EXPOSE 8080

 # Run the built jar file
 CMD ["sh", "-c", "java -jar target/*.jar"]
