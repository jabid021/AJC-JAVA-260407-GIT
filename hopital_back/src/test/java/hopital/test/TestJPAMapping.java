package hopital.test;

import hopital.model.Medecin;
import hopital.model.Patient;
import hopital.model.Secretaire;
import hopital.model.Visite;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class TestJPAMapping {

	public static void main(String[] args) {
		
		Medecin m1 = new Medecin(null,"med1","med1");
		Medecin m2 = new Medecin(null,"med2","med2");
		
		Secretaire s1 = new Secretaire(null,"secretaire1","secretaire1");
		
		Patient p1 = new Patient(10, "Abid","Jordan");
		Patient p2 = new Patient(20, "Doe","John");
		
		Visite v1 = new Visite(p1, m1);
		Visite v2 = new Visite(p2, m2);
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contextJPA");
		
		emf.close();

	}

}
