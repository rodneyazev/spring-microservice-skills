# docker build --tag discovery-server .

FROM eclipse-temurin:17-jdk-jammy

COPY target/*.jar order-service.jar

CMD ["java","-jar","order-service.jar"]