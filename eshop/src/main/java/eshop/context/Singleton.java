package eshop.context;

import eshop.dao.DAOAchat;
import eshop.dao.DAOPersonne;
import eshop.dao.DAOProduit;
import eshop.dao.IDAOAchat;
import eshop.dao.IDAOPersonne;
import eshop.dao.IDAOProduit;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Singleton {
	
	
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("contextJPA");
	
	private IDAOProduit daoProduit = new DAOProduit();
	private IDAOAchat daoAchat = new DAOAchat();
	private IDAOPersonne daoPersonne = new DAOPersonne();
	
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


	public IDAOProduit getDaoProduit() {
		return daoProduit;
	}


	public IDAOAchat getDaoAchat() {
		return daoAchat;
	}


	public IDAOPersonne getDaoPersonne() {
		return daoPersonne;
	}
	
	
	
	
	
	
	

}
