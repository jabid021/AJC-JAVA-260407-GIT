# Ajouter le mode eXécutable sur un fichier pour tous
chmod +x fichier

# Ajouter le mode eXécutable sur un fichier uniquement pour l'utilisateur propriétaire
chmod u+x fichier

# Retirer le mode eXécutable sur un fichier uniquement pour les autres utilisateurs (hors propriétaire et groupe)
chmod o-x fichier

# Appliquer des droits en lecture+écriture+exécution pour le propriétaire, lecture pour le groupe, lecture pour les autres
chmod 744 fichier
