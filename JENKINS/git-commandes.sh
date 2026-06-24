# Générer la clé SSH pour l'associer au compte GitHub
ssh-keygen -t ed25519

# Copier la clé publiquer et l'associer au compte Github
cat ~/.ssh/id_ed25519.pub

# Récupérer la clé privée et la garder de côté pour le moment
cat ~/.ssh/id_ed25519

# On peut vérifier si la connexion SSH est OK avec github.com
ssh -T git@github.com

# (si vous avez changé le chemin par défaut)
ssh -i chemin/vers/cle_ssh_privee -T git@github.com
