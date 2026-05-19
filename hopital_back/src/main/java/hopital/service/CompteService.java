package hopital.service;

import java.util.List;

import hopital.context.Singleton;
import hopital.dao.IDAOCompte;
import hopital.model.Compte;

public class CompteService {

	static IDAOCompte daoCompte =  Singleton.getInstance().getDaoCompte();
	
	public List<Compte> getAll()
	{
		return daoCompte.findAll();
	}
	
	public Compte getById(Integer id) 
	{
		return daoCompte.findById(id);
	}
	
	public Compte getByLoginAndPassword(String login,String password) 
	{
		return daoCompte.findByLoginAndPassword(login, password);
	}
	
	public void insert(Compte compte) 
	{
		daoCompte.save(compte);
	}
	
	public void update(Compte compte) 
	{
		daoCompte.save(compte);
	}

	
	public void delete(Compte compte) 
	{
		daoCompte.deleteById(compte.getId());
	}
	
	public void deleteById(Integer id) 
	{
		daoCompte.deleteById(id);
	}
}
