FROM openjdk:21-jdk
MAINTAINER neves.com
COPY target/book-service-0.0.1-SNAPSHOT.jar aplication.jar
ENTRYPOINT ["java","-jar","/aplication.jar"]