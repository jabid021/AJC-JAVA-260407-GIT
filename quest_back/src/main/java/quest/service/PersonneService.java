package quest.service;

import java.util.List;

import quest.dao.DAOPersonne;
import quest.model.Formateur;
import quest.model.Personne;
import quest.model.Stagiaire;

public class PersonneService {
	
	static DAOPersonne daoPersonne = new DAOPersonne();
	
	public List<Personne> getAll()
	{
		return daoPersonne.findAll();
	}
	public List<Stagiaire> getAllStagiaire()
	{
		return daoPersonne.findAllStagiaire();
	}
	
	public List<Formateur> getAllFormateur()
	{
		return daoPersonne.findAllFormateur();
	}
	public Personne getById(Integer id) 
	{
		return daoPersonne.findById(id);
	}
	
	public Stagiaire getStagiaireById(Integer id) 
	{
		return (Stagiaire) daoPersonne.findById(id);
	}

	public Formateur getFormateurById(Integer id) 
	{
		return (Formateur) daoPersonne.findById(id);
	}
	
	
	public Personne getByLoginAndPassword(String login,String password) 
	{
		return daoPersonne.findByLoginAndPassword(login, password);
	}
	
	public void insert(Personne personne) 
	{
		daoPersonne.insert(personne);
	}
	
	public void update(Personne personne) 
	{
		daoPersonne.update(personne);
	}

	public void delete(Integer id) 
	{
		daoPersonne.delete(id);
	}
}
