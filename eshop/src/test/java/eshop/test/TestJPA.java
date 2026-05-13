package eshop.test;

import eshop.model.Personne;
import eshop.model.Produit;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class TestJPA {

	public static void main(String[] args) {
		
		Personne personne1 = new Personne("Jordan","Abid");
		Personne personne2 = new Personne("John","Doe");
		
		
		Produit produit1 = new Produit("Formation SQL",950);
		Produit produit2 = new Produit("Formation Angular",1250.99);
		
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contextJPA");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
			em.persist(personne1);
			em.persist(personne2);
			em.persist(produit1);
			em.persist(produit2);
		
		em.getTransaction().commit();
		em.close();
		emf.close();

	}

}
