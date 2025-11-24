# ---------- Stage 1: Build the Spring Boot JAR ----------
FROM maven:3.9.6-eclipse-temurin-21 AS builder

WORKDIR /app

# Copy pom.xml and download dependencies (caching)
COPY pom.xml .
RUN mvn dependency:go-offline -B

# Copy project files
COPY . .

# Build the Spring Boot jar (skip tests for faster build)
RUN mvn clean package -DskipTests


# ---------- Stage 2: Run the JAR ----------
FROM eclipse-temurin:21-jre

WORKDIR /app

# Copy jar from builder
COPY --from=builder /app/target/*.jar app.jar

# Expose default port
EXPOSE 8080

# Command to run the jar
ENTRYPOINT ["java", "-jar", "app.jar"]