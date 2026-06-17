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

import quest.model.Formateur;
import quest.service.PersonneService;
import quest.view.Views;

@RestController
@RequestMapping("/api/formateur")
public class FormateurRestController {


	@Autowired
	PersonneService formateurSrv;

	
	@GetMapping
	@JsonView(Views.Formateur.class)
	public List<Formateur> chercherTous()  
	{
		return formateurSrv.getAllFormateur();	
	}
	
	@GetMapping("/{id}")
	@JsonView(Views.Formateur.class)
	public Formateur chercherParId(@PathVariable Integer id)  
	{
		return formateurSrv.getFormateurById(id);
	}
	
	
	@GetMapping("/{id}/cours")
	@JsonView(Views.FormateurWithModules.class)
	public Formateur chercherParIdAvecCours(@PathVariable Integer id)  
	{
		return formateurSrv.getFormateurByIdWithModules(id);
	}
	
	@DeleteMapping("/{id}")
	public void supprimer(@PathVariable Integer id)  
	{
		formateurSrv.delete(id);
	}
	
	@PostMapping
	public Formateur ajouter(@RequestBody Formateur formateur)  
	{
		return (Formateur) formateurSrv.insert(formateur);
	}
	
	@PutMapping("/{id}")
	public Formateur modifier(@PathVariable Integer id,@RequestBody Formateur formateur)  
	{
		formateur.setId(id);
		return (Formateur) formateurSrv.update(formateur);
	}
}
