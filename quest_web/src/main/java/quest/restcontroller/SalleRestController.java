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

import quest.dao.IDAOSalle;
import quest.model.Salle;
import view.Views;

@RestController
@RequestMapping("/api/salle")
public class SalleRestController {


	@Autowired
	IDAOSalle daoSalle;

	
	@GetMapping
	@JsonView(Views.Salle.class)
	public List<Salle> chercherTous()  
	{
		return daoSalle.findAll();	
	}
	
	@GetMapping("/{id}")
	@JsonView(Views.Salle.class)
	public Salle chercherParId(@PathVariable Integer id)  
	{
		return daoSalle.findById(id).orElse(null);
	}
	
	
	@GetMapping("/historique/{id}")
	@JsonView(Views.SalleWithHistorique.class)
	public Salle chercherParIdAvecHistorique(@PathVariable Integer id)  
	{
		return daoSalle.findByIdWithHistorique(id);
	}
	
	@DeleteMapping("/{id}")
	public void supprimer(@PathVariable Integer id)  
	{
		daoSalle.deleteById(id);
	}
	
	@PostMapping
	public Salle ajouter(@RequestBody Salle salle)  
	{
		return daoSalle.save(salle);
	}
	
	@PutMapping("/{id}")
	public Salle modifier(@PathVariable Integer id,@RequestBody Salle salle)  
	{
		salle.setId(id);
		return daoSalle.save(salle);
	}
}
