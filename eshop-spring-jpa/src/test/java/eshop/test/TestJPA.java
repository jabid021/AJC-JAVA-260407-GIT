package eshop.test;

import java.time.LocalDate;

import eshop.model.Achat;
import eshop.model.Client;
import eshop.model.Fournisseur;
import eshop.model.Genre;
import eshop.model.Produit;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class TestJPA {

	public static void main(String[] args) {
		
		Fournisseur fournisseur1 = new Fournisseur("Jordan","Abid",Genre.homme, "AJC INGENIERIE");
		
		Produit produit1 = new Produit("Formation SQL",950,fournisseur1);
		
		Produit produit2 = new Produit("Formation Angular",1250.99,fournisseur1);
		
		
		Client client1 = new Client("John","Doe",Genre.nb,LocalDate.parse("1965-01-22"),"161","Avenue de Verdun","Ivry sur Seine","94200");
		
		//client1.getAchats().add(produit1);
		//client1.getAchats().add(produit2);
		//client1.getAchats().add(produit1);
		
		Achat achat1 = new Achat(LocalDate.parse("2026-01-01"),1,client1,produit1);
		Achat achat2 = new Achat(LocalDate.parse("2026-03-01"),2,client1,produit2);
		Achat achat3 = new Achat(LocalDate.now(),1,client1,produit1);
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contextJPA");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
			em.persist(fournisseur1);
			
			em.persist(produit1);
			em.persist(produit2);
			
			em.persist(client1);
			
			em.persist(achat1);
			em.persist(achat2);
			em.persist(achat3);
		
		
		em.getTransaction().commit();
		em.close();
		emf.close();

	}

}
