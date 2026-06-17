package quest.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import quest.dao.IDAOFiliere;
import quest.model.Filiere;
import quest.view.Views;

@RestController
@RequestMapping("/api/filiere")
public class FiliereRestController {


	@Autowired
	IDAOFiliere daoFiliere;

	
	@GetMapping
	@JsonView(Views.Filiere.class)
	public List<Filiere> chercherTous()  
	{
		return daoFiliere.findAll();	
	}
	
	@GetMapping("/{id}")
	@JsonView(Views.Filiere.class)
	public Filiere chercherParId(@PathVariable Integer id)  
	{
		return daoFiliere.findById(id).orElse(null);
	}
	
	
	@GetMapping("/{id}/stagiaires")
	@JsonView(Views.FiliereWithStagiaires.class)
	public Filiere chercherParIdAvecEleves(@PathVariable Integer id)  
	{
		return daoFiliere.findByIdWithStagiaires(id);
	}
	
	@GetMapping("/{id}/modules")
	@JsonView(Views.FiliereWithModules.class)
	public Filiere chercherParIdAvecCours(@PathVariable Integer id)  
	{
		return daoFiliere.findByIdWithModules(id);
	}
	
	@DeleteMapping("/{id}")
	public void supprimer(@PathVariable Integer id)  
	{
		daoFiliere.deleteById(id);
	}
	
	@PostMapping
	public Filiere ajouter(@RequestBody Filiere filiere)  
	{
		return daoFiliere.save(filiere);
	}
	
	@PutMapping("/{id}")
	public Filiere modifier(@PathVariable Integer id,@RequestBody Filiere filiere)  
	{
		filiere.setId(id);
		return daoFiliere.save(filiere);
	}
}
