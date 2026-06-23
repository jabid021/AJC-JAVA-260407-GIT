package quest.service;

import java.util.List;
import java.util.Optional;

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
		Optional<Matiere> opt = daoMatiere.findById(id);
		if(opt.isPresent()) {return opt.get();}
		else return null;
	}
	
	
	public List<Matiere> getByLibelleContaining(String recherche)
	{
		return daoMatiere.findByLibelleContaining(recherche);
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
