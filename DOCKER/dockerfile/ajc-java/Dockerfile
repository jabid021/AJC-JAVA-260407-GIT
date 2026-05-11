FROM eclipse-temurin:21-jdk

WORKDIR /app

COPY Application.java .

# CMD [ "java", "/app/Application.java" ]

# Utiliser CMD par spécifier l'application par défaut, au démarrage du container, remplaçable par l'utilisateur dans la commande docker run
# CMD [ "java", "Application.java" ]

# Utiliser ENTRYPOINT par spécifier l'application par défaut, au démarrage du container, non remplaçable par l'utilisateur dans la commande docker run
ENTRYPOINT [ "java", "Application.java" ]
CMD [ "--option" ]
