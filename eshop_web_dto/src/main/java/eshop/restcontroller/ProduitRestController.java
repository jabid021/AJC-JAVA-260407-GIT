package eshop.restcontroller;

import java.util.ArrayList;
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

import eshop.dao.IDAOProduit;
import eshop.dto.ProduitDTO;
import eshop.model.Produit;

@RestController
@RequestMapping("/api/produit")
public class ProduitRestController {


	@Autowired
	IDAOProduit daoProduit;

	
	@GetMapping
	public List<ProduitDTO> chercherTous()  
	{
		/*List<ProduitDTO> prods = new ArrayList();
		for(Produit p : daoProduit.findAll()) 
		{
			prods.add(ProduitDTO.convert(p));
		}*/
		return daoProduit.findAll().stream().map(p->ProduitDTO.convert(p)).toList();	
	}
	
	@GetMapping("/{id}")
	public ProduitDTO chercherParId(@PathVariable Integer id)  
	{
		Produit produit = daoProduit.findById(id).orElse(null);
		return ProduitDTO.convert(produit);
	}
	
	
	@GetMapping("/{id}/ventes")
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
	public Produit ajouter(@RequestBody Produit produit)  
	{
		return daoProduit.save(produit);
	}
	
	@PutMapping("/{id}")
	public Produit modifier(@PathVariable Integer id,@RequestBody Produit produit)  
	{
		produit.setId(id);
		return daoProduit.save(produit);
	}
}
