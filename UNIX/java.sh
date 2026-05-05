# Pour compiler une classe Java
javac NomFichierApp.java

# Pour exécuter une classe compilée
java NomFichierApp

# Pour compiler et exécuter un fichier java à la volée
java NomFichierApp.java

# Pour consulter le bycode généré dans le fichier .class
javap -c NomFichierApp

# Pour accéder au shell Java
jshell

# Pour compiler et exécuter une classe principale avec Maven
mvn compile exec:java -Dexec.mainClass="nom.classe.App"
