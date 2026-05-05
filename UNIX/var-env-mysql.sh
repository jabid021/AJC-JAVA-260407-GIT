# Création des variables d'environnement
export JDBC_URL="jdbc:mysql://localhost:3306/projet_quest"
export JDBC_USERNAME="root"
export JDBC_PASSWORD="root"

# Adapter le code IDAO.java
vim AJC-JAVA-260407-GIT/quest_back/src/main/java/quest/dao/IDAO.java

public interface IDAO<T, K> {
    String urlBDD=System.getenv("JDBC_URL");
    String loginBDD=System.getenv("JDBC_USERNAME");
    String passwordBDD=System.getenv("JDBC_PASSWORD");

    // ... la suite ...
}

# Exécuter l'application avec la commande Maven
cd vim AJC-JAVA-260407-GIT/quest_back
mvn compile exec:java -Dexec.mainClass="quest.App"
