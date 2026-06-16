package quest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import quest.dao.IDAOOrdinateur;
import quest.model.Ordinateur;
import quest.model.Stagiaire;
import quest.service.PersonneService;


@Controller
@RequestMapping("/ordinateur")
public class OrdinateurController  {

	@Autowired
	IDAOOrdinateur daoOrdinateur;
	
	@Autowired
	PersonneService personneSrv;
	
	
	
	@GetMapping
	public String chercherTous(Model model)  
	{
		List<Ordinateur> ordinateurs = daoOrdinateur.findAll();
		List<Stagiaire> stagiaireDisponibles = personneSrv.getAllStagiaireDisponibles();
		model.addAttribute("ordinateur", new Ordinateur());
		model.addAttribute("ordinateurs", ordinateurs);
		model.addAttribute("utilisateurs", stagiaireDisponibles);
		return "ordinateurs.jsp";
	}
	
	@GetMapping("/{numero}")
	public String chercherParId(@PathVariable Integer numero,Model model)  
	{
		Ordinateur ordinateur = daoOrdinateur.findById(numero).orElse(null);
		List<Ordinateur> ordinateurs = daoOrdinateur.findAll();
		List<Stagiaire> stagiaireDisponibles = personneSrv.getAllStagiaireDisponibles();
		if(ordinateur.getUtilisateur()!=null) 
		{
			stagiaireDisponibles.add(ordinateur.getUtilisateur());
		}
		model.addAttribute("ordinateur", ordinateur);
		model.addAttribute("ordinateurs", ordinateurs);
		model.addAttribute("utilisateurs", stagiaireDisponibles);
		return "ordinateurs.jsp";
	}
	
	@GetMapping("/delete/{numero}")
	public String supprimer(@PathVariable Integer numero)  
	{
		daoOrdinateur.deleteById(numero);
		return "redirect:/ordinateur";
	}
	
	@PostMapping
	public String ajouter(@ModelAttribute Ordinateur ordinateur)  
	{
		daoOrdinateur.save(ordinateur);
		if(ordinateur.getUtilisateur().getId()==null) 
		{
			ordinateur.setUtilisateur(null);
		}
		return "redirect:/ordinateur";
	}
	
	@PostMapping("/{numero}")
	public String modifier(@PathVariable Integer numero,@ModelAttribute Ordinateur ordinateur)  
	{
		ordinateur.setNumero(numero);
		if(ordinateur.getUtilisateur().getId()==null) 
		{
			ordinateur.setUtilisateur(null);
		}
		daoOrdinateur.save(ordinateur);
		return "redirect:/ordinateur";
	}

}
