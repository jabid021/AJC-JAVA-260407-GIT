#!/bin/bash

# Script de détection d'un changement sur le repo "AJC-JAVA-260407-GIT", recompilation et exécuter de l'application Java

# Ajouter les droits d'exécution sur ce fichier
# chmod +x auto-recompile.sh

cd AJC-JAVA-260407-GIT

git fetch > /dev/null 2>&1

local=$(git rev-parse main)
origin=$(git rev-parse origin/main)

if [ "$local" != "$origin" ]; then
        git pull > /dev/null 2>&1
fi

cd quest_back

mvn compile exec:java -Dexec.mainClass="quest.App"
