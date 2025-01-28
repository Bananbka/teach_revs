FROM openjdk:17-jdk-slim

WORKDIR /app

COPY teacher-reviews/target/teacher-reviews-0.0.1.jar /app/teacher-reviews.jar

EXPOSE 8080

ENTRYPOINT [ "java", "-jar", "/app/teacher-reviews.jar"]