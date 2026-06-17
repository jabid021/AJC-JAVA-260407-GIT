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

import quest.dao.IDAOOrdinateur;
import quest.model.Ordinateur;
import quest.view.Views;

@RestController
@RequestMapping("/api/ordinateur")
public class OrdinateurRestController {


	@Autowired
	IDAOOrdinateur daoOrdinateur;

	
	@GetMapping
	@JsonView(Views.Ordinateur.class)
	public List<Ordinateur> chercherTous()  
	{
		return daoOrdinateur.findAll();	
	}
	
	@GetMapping("/{numero}")
	@JsonView(Views.Ordinateur.class)
	public Ordinateur chercherParNumero(@PathVariable Integer numero)  
	{
		return daoOrdinateur.findById(numero).orElse(null);
	}

	
	@DeleteMapping("/{numero}")
	public void supprimer(@PathVariable Integer numero)  
	{
		daoOrdinateur.deleteById(numero);
	}
	
	@PostMapping
	public Ordinateur ajouter(@RequestBody Ordinateur ordinateur)  
	{
		return daoOrdinateur.save(ordinateur);
	}
	
	@PutMapping("/{numero}")
	public Ordinateur modifier(@PathVariable Integer numero,@RequestBody Ordinateur ordinateur)  
	{
		ordinateur.setNumero(numero);
		return daoOrdinateur.save(ordinateur);
	}
}
