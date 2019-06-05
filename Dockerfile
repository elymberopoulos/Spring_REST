# Start with a base image containing Java runtime
FROM openjdk:latest

# Add Maintainer Info
LABEL description="A sample REST API that accesses data from a MySQL database"

# Add the application's jar to the container
ADD build/libs/REST_MySQL-0.0.1-SNAPSHOT.jar app.jar

# Run the jar file
ENTRYPOINT ["java", "-jar", "app.jar"]

# Make port 8080 available to the world outside this container
EXPOSE 8080