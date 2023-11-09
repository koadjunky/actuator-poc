FROM openjdk:17.0.2-slim-buster
MAINTAINER malycha.eu
COPY actuator-poc-0.0.1-SNAPSHOT.jar actuator-poc.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/actuator-poc.jar"]
