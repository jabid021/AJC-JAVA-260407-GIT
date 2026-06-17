package quest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import quest.dao.IDAOPersonne;
import quest.model.Formateur;
import quest.model.Personne;
import quest.model.Stagiaire;

@Service
public class PersonneService {
	//private static Logger log = LoggerFactory.getLogger(PersonneService.class);

	@Autowired
	IDAOPersonne daoPersonne;

	public List<Personne> getAll()
	{
		return daoPersonne.findAll();
	}
	public List<Stagiaire> getAllStagiaire()
	{
		return daoPersonne.findAllStagiaire();
	}

	public List<Stagiaire> getAllStagiaireDisponibles()
	{
		return daoPersonne.findStagiaireWithoutOrdinateur();
	}
	
	public List<Formateur> getAllFormateur()
	{
		return daoPersonne.findAllFormateur();
	}
	public Personne getById(Integer id)
	{
		return daoPersonne.findById(id).orElse(null);
	}

	public Stagiaire getStagiaireById(Integer id)
	{
		return (Stagiaire) daoPersonne.findById(id).orElse(null);
	}

	public Formateur getFormateurById(Integer id)
	{
		return (Formateur) daoPersonne.findById(id).orElse(null);
	}
	
	public Formateur getFormateurByIdWithModules(Integer id)
	{
		return daoPersonne.findByIdWithModules(id);
	}


	public Personne getByLoginAndPassword(String login,String password)
	{
		//log.info("Connexion en cours ...");
		return daoPersonne.findByLoginAndPassword(login, password);
	}

	public Personne insert(Personne personne)
	{
		return daoPersonne.save(personne);
	}

	public Personne update(Personne personne)
	{
		return daoPersonne.save(personne);
	}

	public void delete(Integer id)
	{
		daoPersonne.deleteById(id);
	}
}
