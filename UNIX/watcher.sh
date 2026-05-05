#!/bin/bash

# Script de surveillance des fichiers java, recompilation et réexécution à la volée

# Pré-requis : installation de inotifywait
# sudo apt install inotify-tools -y

# Ajouter les droits d'exécution sur ce fichier
# chmod +x watcher.sh

# Problème : le programme est interactif avec l'utilisateur, relancer l'appli dans ce script mettrait en pause la surveillance
# > Relancer à la main dans un autre terminal est nécessaire, et le plus propre

cd AJC-JAVA-260407-GIT/quest_back

echo "Surveillance des fichiers .java..."

inotifywait -m -r -e modify,create --exclude '(\.git|\.swp|~$)'  --format '%f' . |
while read file; do
    if [[ "$file" != *.java ]]; then
        continue
    fi

    echo "Changement détecté sur $file ! Kill de l'application java"
    killall -9 java > /dev/null 2>&1
done
