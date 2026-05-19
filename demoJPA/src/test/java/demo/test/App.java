package demo.test;

import demo.model.Filiere;
import demo.model.Film;
import demo.model.joined.Animal;
import demo.model.joined.Elephant;
import demo.model.joined.Lion;
import demo.model.joined.Tigre;
import demo.model.perclass.Avion;
import demo.model.perclass.Bateau;
import demo.model.perclass.Vehicule;
import demo.model.perclass.Voiture;
import demo.model.single.Compte;
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
		
		/*em.getTransaction().begin();
		
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
			
		em.getTransaction().commit();*/
	
		System.out.println("-----------DEMO SINGLETABLE------------------");
		
		System.out.println("Find Medecin 1 : ");
		System.out.println(em.find(Compte.class,1));
		em.close();
		System.out.println("\n---------");
		
		System.out.println("Find Medecin 1 : ");
		em = emf.createEntityManager();
		System.out.println(em.find(Medecin.class,1));
		em.close();
		System.out.println("\n---------");
		
		
		System.out.println("FindAll Comptes : ");
		em = emf.createEntityManager();
		System.out.println(em.createQuery("from Compte").getResultList());
		em.close();
		System.out.println("\n---------");
		
		
		System.out.println("FindAll Medecins : ");
		em = emf.createEntityManager();
		System.out.println(em.createQuery("from Medecin").getResultList());
		em.close();
		System.out.println("\n---------");
		
		
		System.out.println("\n-----------DEMO JOINED------------------");
		
		
		System.out.println("Find Animal 1 : ");
		em = emf.createEntityManager();
		System.out.println(em.find(Animal.class,1));
		em.close();
		System.out.println("\n---------");
		
		System.out.println("Find Animal 1 : ");
		em = emf.createEntityManager();
		System.out.println(em.find(Lion.class,1));
		em.close();
		System.out.println("\n---------");
		
		
		System.out.println("FindAll Animaux : ");
		em = emf.createEntityManager();
		System.out.println(em.createQuery("from Animal").getResultList());
		em.close();
		System.out.println("\n---------");
		
		
		System.out.println("FindAll Lion : ");
		em = emf.createEntityManager();
		System.out.println(em.createQuery("from Lion").getResultList());
		em.close();
		System.out.println("\n---------");
		
		
		System.out.println("\n-----------DEMO TABLE PER CLASS------------------");
		
		
		System.out.println("Find Avion 4 : ");
		em = emf.createEntityManager();
		System.out.println(em.find(Vehicule.class,4));
		em.close();
		System.out.println("\n---------");
		
		System.out.println("Find Avion 4 : ");
		em = emf.createEntityManager();
		System.out.println(em.find(Avion.class,4));
		em.close();
		System.out.println("\n---------");
		
		
		System.out.println("FindAll Vehicules : ");
		em = emf.createEntityManager();
		System.out.println(em.createQuery("from Vehicule").getResultList());
		em.close();
		System.out.println("\n---------");
		
		
		System.out.println("FindAll Avions : ");
		em = emf.createEntityManager();
		System.out.println(em.createQuery("from Avion").getResultList());
		em.close();
		System.out.println("\n---------");
		
		
		
		em.close();
		emf.close();
		
		
		

	}

}
