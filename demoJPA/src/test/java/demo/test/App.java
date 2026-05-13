package demo.test;

import demo.model.Demo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class App {

	public static void main(String[] args) {
		Demo d = new Demo("libelle",false);
		System.out.println(d);
		
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contextJPA");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		em.persist(d);
		
		em.getTransaction().commit();
	
		
		
		System.out.println(em.find(Demo.class, 12));
		System.out.println(em.createQuery("from Demo").getResultList());
		em.close();
		emf.close();
		
		
		

	}

}
