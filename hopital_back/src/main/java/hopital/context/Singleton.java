package hopital.context;

import hopital.dao.DAOCompte;
import hopital.dao.DAOPatient;
import hopital.dao.DAOVisite;
import hopital.dao.IDAOCompte;
import hopital.dao.IDAOPatient;
import hopital.dao.IDAOVisite;
import hopital.service.CompteService;
import hopital.service.PatientService;
import hopital.service.VisiteService;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Singleton {
	
	//Avec le polymorphisme, on pourra changer facilement de DAO au module JPA
	//DAOVisite deviendra DAOVisiteJPA, mais le reste de l'appli fonctionnera toujours !
	private IDAOCompte daoCompte = new DAOCompte();
	private IDAOPatient daoPatient = new DAOPatient();
	private IDAOVisite daoVisite = new DAOVisite();

	private PatientService patientSrv = new PatientService();
	private CompteService compteSrv = new CompteService();
	private VisiteService visiteSrv = new VisiteService();
	
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
	
	
	
	public IDAOCompte getDaoCompte() {
		return daoCompte;
	}
	public IDAOPatient getDaoPatient() {
		return daoPatient;
	}
	public IDAOVisite getDaoVisite() {
		return daoVisite;
	}
	public PatientService getPatientSrv() {
		return patientSrv;
	}
	public CompteService getCompteSrv() {
		return compteSrv;
	}
	public VisiteService getVisiteSrv() {
		return visiteSrv;
	}


	public EntityManagerFactory getEmf() {
		return emf;
	}
	
	
	
	
	
	

}
