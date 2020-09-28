FROM maven:3.6.3-jdk-11-openj9 as build

LABEL maintainer='patrick.richner@stud.hslu.ch'

COPY ./pom.xml ./pom.xml

COPY ./order-service/pom.xml ./order-service/pom.xml

RUN cd order-service && mvn dependency:go-offline -B

COPY ./order-service ./order-service

RUN cd order-service && mvn package

FROM openjdk:11.0.2-jre-slim-stretch

COPY --from=build ./order-service/target/*.jar ./service.jar

CMD java -jar ./service.jar
