FROM maven:3.6.3-jdk-11-openj9 as build

LABEL maintainer='patrick.richner@stud.hslu.ch'

FROM openjdk:11.0.2-jre-slim-stretch

COPY ./target/*.jar ./service.jar

CMD java -jar ./service.jar
