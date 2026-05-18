package krusty.context;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Singleton {
	
	
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("contextJPA");
	private static Singleton instance=null;
	
	
	//Impossible de creer un objet Singleton en dehors de cette page
	//Seule la methode getInstance() peut declencher ce constructeur
	private Singleton() {}
	
	
	//On est sur que l'application retournera toujours le même objet "instance"
	//Si c'est la 1ere fois que la methode est call, instance est initialise avec new Singleton();
	//Sinon, retourne toujours la meme instance
	public static Singleton getInstance() 
	{
		if(instance==null) //1er passage dans getInstance si instance est toujours null
		{
			instance=new Singleton();
		}
		return instance;
	}


	public EntityManagerFactory getEmf() {
		return emf;
	}
	
	
	
	
	
	
	

}
