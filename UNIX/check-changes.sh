#!/bin/bash

# Script de détection d'un changement sur le repo "AJC-JAVA-260407-GIT", journalisation

# Ajouter les droits d'exécution sur ce fichier
# chmod +x check-changes.sh

# Tâche planifiée
# crontab -e
# * * * * * /home/jeremy/check-changes.sh

cd AJC-JAVA-260407-GIT

git fetch > /dev/null 2>&1

dir="/home/jeremy"
changefile="$dir/changes.txt"
logfile="$dir/log.txt"

local=$(git rev-parse main)
origin=$(git rev-parse origin/main)
date=$(date '+%Y-%m-%d %H:%M:%S')

if [ "$local" != "$origin" ]; then
        echo "[$date] Changements détectés!" >> $changefile
        echo "[$date] Changements détectés!" >> $logfile
        git pull > /dev/null 2>&1

else
        echo "[$date] Pas de changements détectés" >> $logfile
fi
