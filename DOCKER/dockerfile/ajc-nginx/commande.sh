# Fabriquer l'image Docker
docker build -t ajc-nginx .

# Exécuter un container à partir de l'image
docker run -d -p 4200:80 ajc-nginx
