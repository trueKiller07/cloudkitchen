FROM openjdk:8-jdk-alpine
COPY target/cloudkitchen-0.0.2-SNAPSHOT.jar cloudkitchen-0.0.2-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/cloudkitchen-0.0.2-SNAPSHOT.jar"]