package krusty.test;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import krusty.model.Client;
import krusty.model.Employe;
import krusty.model.Espece;
import krusty.model.Patron;
import krusty.model.Personnage;
import krusty.model.Produit;

public class TestEntityManager {

	public static void main(String[] args) {
		//Commandes SQL et leur equivalent en JPA : 

		//SELECT where id =  => em.find(Classe.class,id)
		//SELECT * => em.createQuery(....)
		//SELECT where col = ?


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
		//INSERT
		//UPDATE
		//DELETE

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

		em.close();
		emf.close();
	}


}
