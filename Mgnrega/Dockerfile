# ================================
# Build stage
# ================================
FROM maven:3.9.6-eclipse-temurin-21 AS build

WORKDIR /app

# Copy Maven files
COPY Mgnrega/pom.xml ./
COPY Mgnrega/.mvn .mvn
COPY Mgnrega/mvnw ./

# Copy source code
COPY Mgnrega/src ./src

# Package the app
RUN chmod +x mvnw && ./mvnw clean package -DskipTests


# ================================
# Run stage
# ================================
FROM eclipse-temurin:21-jdk-alpine

WORKDIR /app

# Copy built JAR
COPY --from=build /app/target/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
