FROM openjdk:17-jdk-slim


RUN apt-get update && apt-get install -y python3 python3-pip --no-install-recommends \
    && apt-get clean \
    && rm -rf /var/lib/apt/lists/*
RUN pip3 install nltk googletrans

WORKDIR /app

ADD teacher-reviews/target/teacher-reviews-0.0.1.jar /app/teacher-reviews/teacher-reviews.jar
ADD py-modules/ /app/py-modules/

EXPOSE 8080

ENTRYPOINT [ "java", "-jar", "/app/teacher-reviews/teacher-reviews.jar"]