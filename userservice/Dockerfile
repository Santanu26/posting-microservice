FROM amazoncorretto:17-alpine

ADD target/*.jar user-service.jar
ENTRYPOINT ["java", "-jar","user-service.jar"]
