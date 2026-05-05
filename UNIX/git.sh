# Générer une clé SSH
ssh-keygen

# Afficher la clé publique
cat ~/.ssh/id_ed25519.pub

# Tester la connexion vers le github
ssh -T git@github.com

# Cloner un repo
git clone git clone git@github.com:nom_repo.git

# Vérifier le hash du commit local de la branche main
git rev-parse main

# Vérifier le hash du commit distant de la branche main
git rev-parse origin/main
