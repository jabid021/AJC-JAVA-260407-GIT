package krusty.test;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import krusty.model.Client;
import krusty.model.Employe;
import krusty.model.Espece;
import krusty.model.Maison;
import krusty.model.Patron;
import krusty.model.Personnage;
import krusty.model.Produit;

public class TestEntityManager {

	public static void main(String[] args) {
		//Commandes SQL et leur equivalent en JPA : 

		//Par defaut, dans toutes les entity, le chargement des liens en XToMany est en mode Lazy (!=Eager)
		//On peut changer se comportement en modifiant l'attribut fetch = "Eager" dans les @XToMany(ON NE DOIT JAMAIS FAIRE CA!)
			//Ou faire une requete avec le mot JOIN FETCH sur la liste en question
			
		
		
		//SELECT where id =  => em.find(Classe.class,id)
		//SELECT * => em.createQuery(....)
		//SELECT where col = ? => em.createQuery(....).setParameter()


		//CreateQuery permet d'ecrire des SELECT, CEPENDANT, on ecrit plus jamais du SQL, mais du JPQL =>
		//SQL => requete dans une table
		//JavaProgrammingLanguageQuerry => requete sur nos classes

		//Si un seul resultat attendu => .getSingleResult
			//Si la requete ne retourne rien, JPA leve une exception
			//Si un seul resultat sort, GOOD
			//Si plusieurs resultats => JPA Leve une exception
		
		
		//Si plusieurs resutats attendus => .getResultList
			//Si la requete ne retourne aucun resultat => Liste vide []
			//Sinon retourne la liste
		
		//Tout ce qui modifie la bdd (transaction) 
		
		//TOUS LES SELECT VOUS RETURN DES OBJETS MANAGED
		
		
		//INSERT => em.persist(objet)  => l'objet est managed par JPA
			// En autoIncrement, si on donne un id, JPA PAS CONTENT
			// Sans AutoIncrement, si on donne un id deja existant, JPA PAS CONTENT
		
		//UPDATE => copie = em.merge(objet) => objet n'est pas Managed par JPA.... Mais copie l'est !
			//Si l'objet n'a pas d'id, ou un id inexistant => insert l'objet
			//Si l'objet a un id existant => update
		
		//DELETE => em.remove(objet) => objet DOIT etre MANAGED

		//UPDATE where col = ?



		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contextJPA"); //Doit etre unique dans le projet => Se place dans le Singleton
		EntityManager em = emf.createEntityManager();

		Produit produit = em.find(Produit.class,1);
		System.out.println("Fiche du produit 1 : ");
		System.out.println(produit);

		System.out.println("--------------------");

		System.out.println("Voir TOUS les produits");

		List<Produit> produits =  em.createQuery("SELECT p from Produit p").getResultList();
		for(Produit pr : produits) 
		{
			System.out.println(pr);
		}

		System.out.println("----------------");


		System.out.println("Voir TOUS les personnages");

		List<Personnage> persos =  em.createQuery("from Personnage").getResultList();
		for(Personnage p : persos) 
		{
			System.out.println(p);
		}

		System.out.println("----------------");


		System.out.println("Voir TOUS les patrons");

		List<Patron> patrons =  em.createQuery("from Patron").getResultList();
		for(Patron p : patrons) 
		{
			System.out.println(p);
		}

		System.out.println("----------------");



		System.out.println("Voir TOUS les clients");

		List<Client> clients =  em.createQuery("from Client").getResultList();
		for(Client c : clients) 
		{
			System.out.println(c);
		}

		System.out.println("----------------");



		System.out.println("Voir TOUS les personnages qui sont des planctons");

		List<Personnage> planctons =  
				em.createQuery("SELECT p from Personnage p where p.espece=:espece ")
				.setParameter("espece",Espece.Plancton)
				.getResultList();
		for(Personnage p : planctons) 
		{
			System.out.println(p);
		}

		System.out.println("----------------");
		
		
		System.out.println("Se connecter en tant qu'employe : ");
		
		String login = "James Éponge";
		String password = "Stagiaire";
		
		Employe emp= null;
		
		//Employe emp =  (Employe) em.createQuery("SELECT e from Employe e where e.nom=:login and e.job=:password").setParameter("login",login).setParameter("password", password).getSingleResult();
		try { 
		emp =  
				em.createQuery("SELECT e from Employe e where e.nom=:login and e.job=:password",Employe.class)
				.setParameter("login",login)
				.setParameter("password", password)
				.getSingleResult();
		}
		catch(Exception e) {e.printStackTrace();}
		
		if(emp==null) {System.out.println("Identifiants invalides");}
		else 
		{
			System.out.println(emp);
		}

		System.out.println("----------------");

		
		System.out.println("Voir TOUS les noms des personnages");

		List<String> nomPersos =  em.createQuery("SELECT p.nom from Personnage p").getResultList();
		for(String s : nomPersos) 
		{
			System.out.println(s);
		}

		System.out.println("-------OU AVEC UN STREAM----------");
		
		System.out.println(persos.stream().map(p->p.getNom()).toList());
		
		
		System.out.println("----------------");
		
		
		Double frais =  em.createQuery("SELECT SUM(e.salaire) from Employe e",Double.class).getSingleResult();
		System.out.println("Frais de la boite... :"+frais);

		
		System.out.println("----------------");
		
		System.out.println("Voir TOUS les personnages habitant dans un ananas");

		List<Personnage> persoAnanas =  em.createQuery("SELECT p from Personnage p where p.habitation.forme='ananas'").getResultList();
		for(Personnage p : persoAnanas) 
		{
			System.out.println(p);
		}

		System.out.println("----------------");
		
		System.out.println("Voir TOUS les clients AVEC leurs achats (un client sans achat ne sort pas)");

		List<Client> clientsBis =  em.createQuery("SELECT c from Client c JOIN FETCH c.achats").getResultList();
		
		
		
		for(Client c : clientsBis) 
		{
			System.out.println(c);
			System.out.println("Voir les achats du client :  ");
			System.out.println(c.getAchats());
		}

		System.out.println("-------------");
		
		
		System.out.println("Voir TOUS les clients AVEC leurs achats (MEME les client sans Achats (Ajout du mot cle LEFT))");

		List<Client> clientsBis2 =  em.createQuery("SELECT c from Client c LEFT JOIN FETCH c.achats").getResultList();
		

		
		for(Client c : clientsBis2) 
		{
			System.out.println(c);
			System.out.println("Voir les achats du client :  ");
			System.out.println(c.getAchats());
		}

		
		System.out.println("-------------");
		
		
		

		System.out.println("Voir TOUS les clients AVEC un achat qui a une qte >= 5");

		List<Client> clientsBis3 =  em.createQuery("SELECT c from Client c JOIN c.achats a where a.quantite>=5 ").getResultList();
	
		
		//em.createNativeQuery("select * from product");
		
		for(Client c : clientsBis3) 
		{
			System.out.println(c);

		}
		
		System.out.println("-------------");
		
		
		
		
		System.out.println("--------------FIN DEMO SELECT------------------");
		
		Maison ajc = new Maison("AJCTER","161bis","Avenue de Verdun","Ivry","94200");
		//ajc.setId(6);
		
		
		em.getTransaction().begin();
		
		//Faire un update custom : 
		//em.createQuery("UPDATE Employe e set e.salaire = e.salaire+10").executeUpdate();
			
		//em.persist(ajc);
			ajc=em.merge(ajc);
			em.remove(ajc);
		
		
		em.getTransaction().commit();
		
		em.close();
		
		System.out.println(ajc);
		
		emf.close();
	}


}
