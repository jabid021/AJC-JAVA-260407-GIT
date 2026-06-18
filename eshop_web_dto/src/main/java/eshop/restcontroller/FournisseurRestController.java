package eshop.restcontroller;

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

import eshop.dao.IDAOPersonne;
import eshop.model.Fournisseur;

@RestController
@RequestMapping("/api/fournisseur")
public class FournisseurRestController {


	@Autowired
	IDAOPersonne daoPersonne;

	
	@GetMapping
	public List<Fournisseur> chercherTous()  
	{
		return daoPersonne.findAllFournisseur();	
	}
	
	@GetMapping("/{id}")
	public Fournisseur chercherParId(@PathVariable Integer id)  
	{
		return (Fournisseur) daoPersonne.findById(id).orElse(null);
	}
	
	
	@GetMapping("/{id}/stock")
	public Fournisseur chercherParIdAvecStock(@PathVariable Integer id)  
	{
		return daoPersonne.findByIdWithStock(id);
	}
	
	@DeleteMapping("/{id}")
	public void supprimer(@PathVariable Integer id)  
	{
		daoPersonne.deleteById(id);
	}
	
	@PostMapping
	public Fournisseur ajouter(@RequestBody Fournisseur fournisseur)  
	{
		return daoPersonne.save(fournisseur);
	}
	
	@PutMapping("/{id}")
	public Fournisseur modifier(@PathVariable Integer id,@RequestBody Fournisseur fournisseur)  
	{
		fournisseur.setId(id);
		return daoPersonne.save(fournisseur);
	}
}
