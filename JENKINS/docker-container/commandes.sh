# Créer l'image ajc/jenkins
docker build -t ajc/jenkins .

# Démarrer un container à partir de l'image Jenkins buildé, avec le binding de port vers 8080, et le binding de Docker du poste
docker run -d --name jenkins -p 8500:8080 -v /var/run/docker.sock:/var/run/docker.sock ajc/jenkins

# Se connecter sur le container
docker exec -it jenkins bash

# Vérifier si la commande docker fonctionne ici
docker ps

# On en profite pour récupérer le mot de passe de l'admin
cat /var/jenkins_home/secrets/initialAdminPassword
