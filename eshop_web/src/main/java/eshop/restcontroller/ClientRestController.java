package eshop.restcontroller;

import java.time.LocalDate;
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

import eshop.dao.IDAOAchat;
import eshop.dao.IDAOPersonne;
import eshop.dao.IDAOProduit;
import eshop.dto.PanierDTO;
import eshop.model.Achat;
import eshop.model.Client;
import eshop.model.Produit;
import eshop.view.Views;

@RestController
@RequestMapping("/api/client")
public class ClientRestController {


	@Autowired
	IDAOPersonne daoPersonne;
	
	@Autowired
	IDAOAchat daoAchat;
	
	@GetMapping
	@JsonView(Views.Client.class)
	public List<Client> chercherTous()  
	{
		return daoPersonne.findAllClient();	
	}
	
	@GetMapping("/{id}")
	@JsonView(Views.Client.class)
	public Client chercherParId(@PathVariable Integer id)  
	{
		Client client = (Client) daoPersonne.findById(id).orElse(null);
		return client;
	}
	
	
	@GetMapping("/{id}/achats")
	@JsonView(Views.ClientWithAchats.class)
	public Client chercherParIdAvecAchats(@PathVariable Integer id)  
	{
		return daoPersonne.findByIdWithAchats(id);
	}
	
	@DeleteMapping("/{id}")
	public void supprimer(@PathVariable Integer id)  
	{
		daoPersonne.deleteById(id);
	}
	
	@PostMapping
	public Client ajouter(@RequestBody Client client)  
	{
		return daoPersonne.save(client);
	}
	
	@PutMapping("/{id}")
	public Client modifier(@PathVariable Integer id,@RequestBody Client client)  
	{
		client.setId(id);
		return daoPersonne.save(client);
	}
	
	/*@PostMapping("/panier")
	public void panier(@RequestBody Map<String,Integer> panier) 
	{
		for(String key : panier.keySet()) 
		{
			System.out.println(key+" - "+panier.get(key));
		}
		Client client = (Client) daoPersonne.findById( panier.get("client")).orElse(null);
		Produit produit = daoProduit.findById(panier.get("produit")).orElse(null);
		Integer quantite = panier.get("qte");
		
		Achat achat = new Achat(LocalDate.now(), quantite, client, produit);
		daoAchat.save(achat);
				
	}*/
	
	
	
	@PostMapping("/panier")
	public void panier(@RequestBody PanierDTO panier) 
	{
		Client client = new Client();
		client.setId(panier.getClient());
		
		Produit produit = new Produit();
		produit.setId(panier.getProduit());
		Integer quantite = panier.getQuantite();
		
		Achat achat = new Achat(LocalDate.now(), quantite, client, produit);
		daoAchat.save(achat);
				
	}
}
