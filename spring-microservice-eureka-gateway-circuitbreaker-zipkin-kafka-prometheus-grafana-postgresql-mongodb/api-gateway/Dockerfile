# docker build --tag discovery-server .

FROM eclipse-temurin:17-jdk-jammy

COPY target/*.jar api-gateway.jar

CMD ["java","-jar","api-gateway.jar"]