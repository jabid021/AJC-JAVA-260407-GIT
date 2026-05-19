package quest.context;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import quest.dao.DAOFiliere;
import quest.dao.DAOMatiere;
import quest.dao.DAOModule;
import quest.dao.DAOOrdinateur;
import quest.dao.DAOPersonne;
import quest.dao.DAOSalle;
import quest.dao.IDAOFiliere;
import quest.dao.IDAOMatiere;
import quest.dao.IDAOModule;
import quest.dao.IDAOOrdinateur;
import quest.dao.IDAOPersonne;
import quest.dao.IDAOSalle;
import quest.service.MatiereService;
import quest.service.PersonneService;

public class Singleton {
	
	//Avec le polymorphisme, on pourra changer facilement de DAO au module JPA
	//DAOVisite deviendra DAOVisiteJPA, mais le reste de l'appli fonctionnera toujours !
	private IDAOFiliere daoFiliere = new DAOFiliere();
	private IDAOMatiere daoMatiere = new DAOMatiere();
	private IDAOModule daoModule = new DAOModule();
	private IDAOPersonne daoPersonne = new DAOPersonne();
	private IDAOSalle daoSalle = new DAOSalle();
	private IDAOOrdinateur daoOrdinateur = new DAOOrdinateur();

	private MatiereService matiereSrv = new MatiereService();
	private PersonneService personneSrv = new PersonneService();
	
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
	
	


	public IDAOFiliere getDaoFiliere() {
		return daoFiliere;
	}


	public IDAOMatiere getDaoMatiere() {
		return daoMatiere;
	}


	public IDAOModule getDaoModule() {
		return daoModule;
	}


	public IDAOPersonne getDaoPersonne() {
		return daoPersonne;
	}


	public IDAOSalle getDaoSalle() {
		return daoSalle;
	}


	public IDAOOrdinateur getDaoOrdinateur() {
		return daoOrdinateur;
	}


	public MatiereService getMatiereSrv() {
		return matiereSrv;
	}


	public PersonneService getPersonneSrv() {
		return personneSrv;
	}


	public EntityManagerFactory getEmf() {
		return emf;
	}
	
	
	
	
	
	

}
