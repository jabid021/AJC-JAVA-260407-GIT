package quest.service;

import java.util.List;

import quest.dao.DAOMatiere;
import quest.model.Matiere;

public class MatiereService {
	
	static DAOMatiere daoMatiere = new DAOMatiere();
	
	public List<Matiere> getAll()
	{
		return daoMatiere.findAll();
	}
	
	public Matiere getById(Integer id) 
	{
		return daoMatiere.findById(id);
	}
	
	public void insert(Matiere matiere) 
	{
		daoMatiere.insert(matiere);
	}
	
	public void update(Matiere matiere) 
	{
		daoMatiere.update(matiere);
	}

	public void delete(Integer id) 
	{
		daoMatiere.delete(id);
	}
}
