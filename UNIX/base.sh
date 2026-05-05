# Créer un répertoire
mkdir repertoire

# Afficher le répertoire en cours
pwd

# Changer de répertoire
cd repertoire

# Supprimer un fichier
rm fichier

# Supprimer un répertoire
rm -R fichier

# Imprimer sur la sortie standard (écran)
echo "Bonjour"

# Rediriger la sortie standard vers un fichier
echo "Bonjour" > fichier

# Rediriger la sortie standard vers un fichier (en concaténant)
echo "Bonjour" >> fichier

# Lister tous les fichiers en liste du répertoire /dev, et l'écrire dans un fichier "fichiers.txt" dans le répertoire en cours
ls -la /dev > fichiers.txt

# Imprimer le contenu du fichier
cat fichiers.txt

# Combien de fichiers et répertoires sont contenus dans le répertoire racine ? Placer le résultat dans un fichier "count.txt"
ls -1 / | wc -l > count.txt

# Créer un fichier "hello.java"
touch hello.java
# ET/OU
vi hello.java
# ET/OU
vim hello.java
# ET/OU
nano hello.java
# OU
echo "CODE JAVA" > hello.java

# Exécuter le code java contenu dans le fichier "hello.java"
java hello.java

# Trouver et tuer un processus (/bin/sh par exemple)
ps -aux | grep /bin/sh
sudo kill -9 <pid_trouve>

# Chercher un fichier dans un répertoire
find -name nom_fichier

# Afficher la troisième ligne d'un fichier
head -n3 fichier | tail -n1
# OU
head -3 fichier | tail -1

# Exécuter une commande (par exemple la commande rm) en tant qu'administrateur (superuser / root)
sudo rm -rf /

# Rester en tant qu'administrateur
sudo su

# Installer une application
sudo apt install app1 app2

# Installer une application sans prompt utilisateur
sudo apt install app1 app2 -y

# Nettoyer l'écran
clear

# Arrêter le système
shutdown

# Redémarrer le système
reboot

# Voir les commandes passées
history
