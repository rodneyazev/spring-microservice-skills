# docker build --tag discovery-server .

FROM eclipse-temurin:17-jdk-jammy

COPY target/*.jar inventory-service.jar

CMD ["java","-jar","inventory-service.jar"]