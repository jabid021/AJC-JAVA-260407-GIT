package quest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import quest.dao.IDAOMatiere;
import quest.model.Matiere;

@Service
public class MatiereService {
	
	@Autowired
	IDAOMatiere daoMatiere;
	
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
		daoMatiere.save(matiere);
	}
	
	public void update(Matiere matiere) 
	{
		daoMatiere.save(matiere);
	}

	public void delete(Integer id) 
	{
		daoMatiere.deleteById(id);
	}
}
