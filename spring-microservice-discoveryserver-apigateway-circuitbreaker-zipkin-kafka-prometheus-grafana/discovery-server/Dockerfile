# docker build --tag discovery-server .

FROM eclipse-temurin:17-jdk-jammy

COPY target/*.jar discovery-server.jar

CMD ["java","-jar","discovery-server.jar"]