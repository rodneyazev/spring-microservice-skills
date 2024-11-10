# docker build --tag discovery-server .

FROM eclipse-temurin:17-jdk-jammy

COPY target/*.jar notification-service.jar

CMD ["java","-jar","notification-service.jar"]