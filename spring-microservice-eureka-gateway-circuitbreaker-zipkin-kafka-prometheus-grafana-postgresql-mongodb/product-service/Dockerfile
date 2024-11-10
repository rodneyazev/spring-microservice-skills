# docker build --tag discovery-server .

FROM eclipse-temurin:17-jdk-jammy

COPY target/*.jar product-service.jar

CMD ["java","-jar","product-service.jar"]