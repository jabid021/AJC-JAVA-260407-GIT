package eshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import eshop.dao.IDAOPersonne;
import eshop.model.Client;


@Controller
@RequestMapping("/client")
public class ClientController  {

	@Autowired
	IDAOPersonne daoPersonne;

	
	@GetMapping
	public String chercherTous(Model model)  
	{
		List<Client> clients = daoPersonne.findAllClient();
		model.addAttribute("client", new Client());
		model.addAttribute("clients", clients);
		return "clients";
	}
	
	@GetMapping("/{id}")
	public String chercherParId(@PathVariable Integer id,Model model)  
	{
		Client client = (Client) daoPersonne.findById(id).orElse(null);
		List<Client> clients = daoPersonne.findAllClient();
		model.addAttribute("client", client);
		model.addAttribute("clients", clients);
		return "clients";
	}
	
	@GetMapping("/delete/{id}")
	public String supprimer(@PathVariable Integer id)  
	{
		daoPersonne.deleteById(id);
		return "redirect:/client";
	}
	
	@PostMapping
	public String ajouter(@ModelAttribute Client client)  
	{
		daoPersonne.save(client);
		return "redirect:/client";
	}
	
	@PostMapping("/{id}")
	public String modifier(@PathVariable Integer id,@ModelAttribute Client client)  
	{
		client.setId(id);
		daoPersonne.save(client);
		return "redirect:/client";
	}

}
