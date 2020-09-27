FROM maven:3.6.3-jdk-11-openj9 as build

LABEL maintainer='patrick.richner@stud.hslu.ch'

#COPY ./pom.xml ./pom.xml

COPY ./product-service/pom.xml ./product-service/pom.xml

RUN cd product-service && mvn dependency:go-offline -B

COPY ./product-service ./product-service

RUN cd product-service && mvn package

FROM openjdk:11.0.2-jre-slim-stretch

COPY --from=build ./product-service/target/*.jar ./service.jar

CMD java -jar ./service.jar
