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

import quest.model.Stagiaire;
import quest.service.PersonneService;
import quest.view.Views;

@RestController
@RequestMapping("/api/stagiaire")
public class StagiaireRestController {


	@Autowired
	PersonneService stagiaireSrv;

	
	@GetMapping
	@JsonView(Views.Stagiaire.class)
	public List<Stagiaire> chercherTous()  
	{
		return stagiaireSrv.getAllStagiaire();	
	}
	
	@GetMapping("/{id}")
	@JsonView(Views.Stagiaire.class)
	public Stagiaire chercherParId(@PathVariable Integer id)  
	{
		return stagiaireSrv.getStagiaireById(id);
	}
	
	
	@DeleteMapping("/{id}")
	public void supprimer(@PathVariable Integer id)  
	{
		stagiaireSrv.delete(id);
	}
	
	@PostMapping
	public Stagiaire ajouter(@RequestBody Stagiaire stagiaire)  
	{
		return (Stagiaire) stagiaireSrv.insert(stagiaire);
	}
	
	@PutMapping("/{id}")
	public Stagiaire modifier(@PathVariable Integer id,@RequestBody Stagiaire stagiaire)  
	{
		stagiaire.setId(id);
		return (Stagiaire) stagiaireSrv.update(stagiaire);
	}
}
