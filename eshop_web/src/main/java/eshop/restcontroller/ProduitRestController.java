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

import com.fasterxml.jackson.annotation.JsonView;

import eshop.dao.IDAOProduit;
import eshop.model.Produit;
import eshop.view.Views;

@RestController
@RequestMapping("/api/produit")
public class ProduitRestController {


	@Autowired
	IDAOProduit daoProduit;

	
	@GetMapping
	@JsonView(Views.Produit.class)
	public List<Produit> chercherTous()  
	{
		return daoProduit.findAll();	
	}
	
	@GetMapping("/{id}")
	@JsonView(Views.Produit.class)
	public Produit chercherParId(@PathVariable Integer id)  
	{
		return (Produit) daoProduit.findById(id).orElse(null);
	}
	
	
	@GetMapping("/{id}/ventes")
	@JsonView(Views.ProduitWithVentes.class)
	public Produit chercherParIdAvecVentes(@PathVariable Integer id)  
	{
		return daoProduit.findByIdWithVentes(id);
	}
	
	@DeleteMapping("/{id}")
	public void supprimer(@PathVariable Integer id)  
	{
		daoProduit.deleteById(id);
	}
	
	@PostMapping
	@JsonView(Views.Produit.class)
	public Produit ajouter(@RequestBody Produit produit)  
	{
		return daoProduit.save(produit);
	}
	
	@PutMapping("/{id}")
	@JsonView(Views.Produit.class)
	public Produit modifier(@PathVariable Integer id,@RequestBody Produit produit)  
	{
		produit.setId(id);
		return daoProduit.save(produit);
	}
}
