# Use an official Maven image to build the JAR
FROM maven:3.8.5-openjdk-11 AS builder
WORKDIR /app

# Copy the Maven project files
COPY pom.xml .
COPY src ./src

# Run Maven build (will download dependencies & compile)
RUN mvn clean package -DskipTests

# Use a lightweight JDK image for the final container
FROM openjdk:11-jdk
WORKDIR /app

# Copy the built JAR from the builder stage
COPY --from=builder /app/target/orderservice.jar app.jar

# Expose the application port
EXPOSE 8082 9090

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]

