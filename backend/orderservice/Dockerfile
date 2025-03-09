# Use an official Maven image to build the JAR
FROM maven:3.8.5-openjdk-11 AS builder
WORKDIR /app

# Copy the Maven project files separately for caching
COPY pom.xml .
RUN mvn dependency:go-offline -B  # Pre-download dependencies

# Copy the source code
COPY src ./src

# Build the application (skip tests to speed up)
RUN mvn clean package -DskipTests

# Use a lightweight JDK image for running the app
FROM openjdk:11-jdk
WORKDIR /app

# Copy the built JAR from the builder stage
COPY --from=builder /app/target/orderservice.jar app.jar

# Expose the correct ports (8081 for Order Service, 9090 if needed)
EXPOSE 8081 9090

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
