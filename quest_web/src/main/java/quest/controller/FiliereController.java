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

import quest.dao.IDAOFiliere;
import quest.dao.IDAOSalle;
import quest.model.Filiere;
import quest.model.Salle;


@Controller
@RequestMapping("/filiere")
public class FiliereController {

	@Autowired
	IDAOFiliere daoFiliere;
	
	@Autowired
	IDAOSalle daoSalle;
	
	@GetMapping
	public String chercherTous(Model model)
	{
		List<Filiere> filieres = daoFiliere.findAll();
		List<Salle> salles = daoSalle.findAll();
		model.addAttribute("filiere", new Filiere());
		model.addAttribute("filieres", filieres);
		model.addAttribute("salles",salles);
		return ("/WEB-INF/filieres.jsp");	
	}
	
	
	@GetMapping("/{id}")
	public String chercherParId(@PathVariable Integer id,Model model)
	{
		List<Filiere> filieres = daoFiliere.findAll();
		Filiere filiere = daoFiliere.findById(id).orElse(null);
		List<Salle> salles = daoSalle.findAll();
		model.addAttribute("filiere", filiere);
		model.addAttribute("filieres", filieres);
		model.addAttribute("salles",salles);
		return "/WEB-INF/filieres.jsp";
		
	}
	
	@GetMapping("/delete/{id}")
	public String supprimer(@PathVariable Integer id) 
	{
		daoFiliere.deleteById(id);
		return "redirect:/filiere";
	}
	
	@PostMapping
	public String ajouter(@ModelAttribute Filiere filiere) 
	{
		if(filiere.getSalle().getId()==null) 
		{
			filiere.setSalle(null);
		}
		daoFiliere.save(filiere);
		return "redirect:/filiere";
	}
	
	@PostMapping("/{id}")
	public String modifier(@PathVariable Integer id,@ModelAttribute Filiere filiere) 
	{
		filiere.setId(id);
		if(filiere.getSalle().getId()==null) 
		{
			filiere.setSalle(null);
		}
		daoFiliere.save(filiere);
		return "redirect:/filiere";
	}

}
