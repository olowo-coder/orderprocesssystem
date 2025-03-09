# Use a Maven image to build the JAR
FROM maven:3.8.5-openjdk-11 AS builder
WORKDIR /app

# Copy the Maven project files separately to leverage Docker caching
COPY pom.xml .
RUN mvn dependency:go-offline -B  # Download dependencies first

# Copy the source code
COPY src ./src

# Build the application (skip tests for faster builds)
RUN mvn clean package -DskipTests

# Use a lightweight JDK image for running the app
FROM openjdk:11-jdk
WORKDIR /app

# Copy the built JAR from the builder stage
COPY --from=builder /app/target/inventoryservice.jar app.jar

# Expose ports
EXPOSE 8082 9091

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
