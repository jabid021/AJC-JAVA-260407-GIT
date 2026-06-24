# Image Java d'exécution
FROM eclipse-temurin:21-jdk

# Répertoire de travail
WORKDIR /app

# Copie du jar généré par Maven
COPY ./target/*.jar quest-boot.jar 

# Lancement de l'application
CMD ["java", "-jar", "/app/quest-boot.jar"]

# Port utilisé par Spring Boot
EXPOSE 8080

