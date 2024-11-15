FROM maven:3.6.3-openjdk-17 as build

COPY src /app/src
COPY pom.xml /app

WORKDIR /app

RUN mvn clean package -DskipTests=true

FROM openjdk:17-jdk-alpine

COPY --from=build app/target/payment-0.0.1-SNAPSHOT.jar goodfood-payment.jar

ENTRYPOINT ["java","-jar","/goodfood-payment.jar"]
