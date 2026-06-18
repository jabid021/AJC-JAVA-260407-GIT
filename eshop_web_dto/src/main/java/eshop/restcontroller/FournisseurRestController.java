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
import eshop.dto.FournisseurDTO;
import eshop.model.Fournisseur;

@RestController
@RequestMapping("/api/fournisseur")
public class FournisseurRestController {


	@Autowired
	IDAOPersonne daoPersonne;

	
	@GetMapping
	public List<FournisseurDTO> chercherTous()  
	{
		return daoPersonne.findAllFournisseur().stream().map(fournisseur->FournisseurDTO.convert(fournisseur)).toList();	
	}
	
	@GetMapping("/{id}")
	public FournisseurDTO chercherParId(@PathVariable Integer id)  
	{
		return FournisseurDTO.convert((Fournisseur) daoPersonne.findById(id).orElse(null));
	}
	
	
	@GetMapping("/{id}/stock")
	public FournisseurDTO chercherParIdAvecStock(@PathVariable Integer id)  
	{
		return FournisseurDTO.convertWithProduits(daoPersonne.findByIdWithStock(id));
	}
	
	@DeleteMapping("/{id}")
	public void supprimer(@PathVariable Integer id)  
	{
		daoPersonne.deleteById(id);
	}
	
	@PostMapping
	public FournisseurDTO ajouter(@RequestBody Fournisseur fournisseur)  
	{
		return FournisseurDTO.convert(daoPersonne.save(fournisseur));
	}
	
	@PutMapping("/{id}")
	public FournisseurDTO modifier(@PathVariable Integer id,@RequestBody Fournisseur fournisseur)  
	{
		fournisseur.setId(id);
		return FournisseurDTO.convert(daoPersonne.save(fournisseur));
	}
}
