package demo.test;

import demo.model.Filiere;
import demo.model.Film;
import demo.model.joined.Elephant;
import demo.model.joined.Lion;
import demo.model.joined.Tigre;
import demo.model.perclass.Avion;
import demo.model.perclass.Bateau;
import demo.model.perclass.Voiture;
import demo.model.single.Medecin;
import demo.model.single.Secretaire;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class App {

	public static void main(String[] args) {
		
		Film film1 = new Film("Quack");
		Film film2 = new Film("Quack Quack - le retour");
		
		Filiere filiere1 = new Filiere("I-260407-JAVA");
		Filiere filiere2 = new Filiere("I-260831-JAVA");
		
		
		Medecin medecin1 = new Medecin("med1","med1",23,"Jordan");
		Medecin medecin2 = new Medecin("med2","med2",26,"Jeremy");
		Secretaire secretaire = new Secretaire("sec","sec");
		
		Lion simba = new Lion("Orange",true);
		Lion scar = new Lion("Rouge",false);
		Elephant dumbo = new Elephant("Gris");
		Tigre tigrou = new Tigre("Orange","Tigrou");
	
		Voiture voiture1 = new Voiture(4,5,true);
		Voiture voiture2 = new Voiture(2,1,false);
		Bateau bateau = new Bateau(0,800);
		Avion avion = new Avion(2,300,"Air France");
		
		
		
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contextJPA");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
			em.persist(medecin1);
			em.persist(medecin2);
			em.persist(secretaire);
			em.persist(simba);
			em.persist(scar);
			em.persist(tigrou);
			em.persist(dumbo);
			em.persist(voiture1);
			em.persist(voiture2);
			em.persist(bateau);
			em.persist(avion);
			
		em.getTransaction().commit();
	

		em.close();
		emf.close();
		
		
		

	}

}
