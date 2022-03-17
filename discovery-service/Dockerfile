# Alpine because it's lighter
FROM openjdk:8-jdk-alpine

# Add JAR file and run it as entrypoint
ADD target/discovery-service.jar app.jar

ENTRYPOINT ["java", "-jar", "/app.jar"]