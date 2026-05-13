package krusty.test;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import krusty.model.Client;
import krusty.model.Employe;
import krusty.model.Espece;
import krusty.model.Humeur;
import krusty.model.Laboratoire;
import krusty.model.Maison;
import krusty.model.Patron;
import krusty.model.Produit;
import krusty.model.Restaurant;

public class App {

	public static void main(String[] args) 
	{
		Maison manoir = new Maison("Asile des Joyeux Crabes", "112", "voie Evil", "Bikini Bottom", "Croquette");
		Maison hotel = new Maison("Autel Junior Client", "42", "allée des Sardines", "Bikini Bottom", "Boîte de conserve");
		Maison ananas = new Maison("Ananas Jaune Carnivore", "55", "place Sylvananas", "Bikini Bottom", "Ananas");
		Laboratoire labosecret = new Laboratoire("Laboratoire secret de Plankton", "???", "voie là chuiperdu", "Bikini Bottom?", true);

		Client c1 = new Client("Armand", "#00ff00", Espece.Etoile_de_mer, Arrays.asList(Humeur.valueOf("FATIGUE")), hotel);
		Client c2 = new Client("Jérémy", "#000000", Espece.Calamar, Arrays.asList(Humeur.valueOf("FATIGUE")), hotel);
		Client c3 = new Client("Clémence", "#000000", Espece.Plancton, Arrays.asList(Humeur.valueOf("FATIGUE")), hotel);
		Client c4 = new Client("Plankton","green",Espece.Plancton,Arrays.asList(Humeur.AVARE,Humeur.ENERVE),labosecret);

		Patron p1 = new Patron("Captain ABID", "#f3724f", Espece.Crabe,Arrays.asList(Humeur.AVARE), 6666.66, manoir);
		Restaurant krustykrab = new Restaurant("Crousty Krab", "1", "place Krabkrab", "Bikini Bottom", 67, LocalTime.parse("04:00:00"), LocalTime.parse("17:00:00"), p1);

		Employe e1 = new Employe("James Éponge", "#ffff00", Espece.Eponge, Arrays.asList(Humeur.NAIF,Humeur.JOYEUX), ananas, "Stagiaire", 0.0,krustykrab);


		Produit pateCrabe = new Produit("Paté de crabe", 1.25, 1500, krustykrab);

		pateCrabe.getAcheteurs().add(c1);
		pateCrabe.getAcheteurs().add(c2);
		pateCrabe.getAcheteurs().add(c3);


		System.out.println(pateCrabe);
		
		
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contextJPA");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
			em.persist(pateCrabe);
		
		em.getTransaction().commit();
		em.close();
		emf.close();
		
		

	}

}