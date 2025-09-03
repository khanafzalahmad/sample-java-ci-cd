FROM openjdk:17-jdk-slim

WORKDIR /app

# We expect the JAR to be produced by Maven in target/
# The GitHub Actions job will run 'mvn package' before docker build
COPY target/sample-java-ci-cd-1.0-SNAPSHOT.jar app.jar

EXPOSE 8080
ENTRYPOINT ["java","-jar","app.jar"]
