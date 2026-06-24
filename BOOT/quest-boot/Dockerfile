FROM eclipse-temurin:21-jdk

WORKDIR /app

COPY ./target/*.jar quest-boot.jar

CMD [ "java", "-jar", "/app/quest-boot.jar" ]

EXPOSE 8080
