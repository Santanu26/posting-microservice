
FROM amazoncorretto:17-alpine

ADD target/*.jar post-service.jar
ENTRYPOINT ["java", "-jar", "post-service.jar"]