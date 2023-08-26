FROM openjdk:17-jdk
WORKDIR /usr/src/app
COPY hexagonal-infrastructure/build/libs/hexagonal-infrastructure-0.0.1-SNAPSHOT.jar hexagonal-infrastructure/build/libs/app-0.0.1-SNAPSHOT.jar
EXPOSE 8080
CMD ["java","-jar","hexagonal-infrastructure/build/libs/app-0.0.1-SNAPSHOT.jar"]