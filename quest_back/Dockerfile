FROM maven:3.9.15-eclipse-temurin-21 AS builder

WORKDIR /app

COPY pom.xml .

# Permet de télécharger les dépendances maven, sans faire de compilation
# > Permet de garder en cache Docker les dépendances, tant que le fichier pom.xml ne change pas
# > L'option -B permet d'exécuter maven en mode Batch (sans interaction)
RUN mvn dependency:go-offline -B

COPY src src

RUN mvn clean package -B -DskipTests



FROM eclipse-temurin:21-jdk

WORKDIR /app

COPY --from=builder /app/target/quest*.jar quest-back.jar

CMD [ "java", "-jar", "quest-back.jar" ]
