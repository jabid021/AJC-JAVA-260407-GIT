FROM eclipse-temurin:21-jre-alpine
WORKDIR /app 
COPY target/quest-boot-*.jar app.jar
EXPOSE 4200:80
ENTRYPOINT ["java", "-jar", "app.jar"]