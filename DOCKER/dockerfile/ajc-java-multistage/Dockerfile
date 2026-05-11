FROM maven:3.9.15-eclipse-temurin-21 AS builder

WORKDIR /app

COPY Application.java .

# RUN mvn clean package
RUN javac /app/Application.java


FROM eclipse-temurin:21-jdk

WORKDIR /app

COPY --from=builder /app/Application.class .

CMD [ "java", "Application" ]
