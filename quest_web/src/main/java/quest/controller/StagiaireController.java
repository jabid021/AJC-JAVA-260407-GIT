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
import quest.model.Filiere;
import quest.model.Genre;
import quest.model.Stagiaire;
import quest.service.PersonneService;


@Controller
@RequestMapping("/stagiaire")
public class StagiaireController {

	@Autowired
	PersonneService personneSrv;
	
	@Autowired
	IDAOFiliere daoFiliere;
	
	@GetMapping
	public String chercherTous(Model model)
	{
		List<Stagiaire> stagiaires = personneSrv.getAllStagiaire();
		List<Filiere> filieres = daoFiliere.findAll();
		model.addAttribute("stagiaire", new Stagiaire());
		model.addAttribute("stagiaires", stagiaires);
		model.addAttribute("filieres",filieres);
		model.addAttribute("civilites",Genre.values());
		return ("stagiaires.jsp");	
	}
	
	
	@GetMapping("/{id}")
	public String chercherParId(@PathVariable Integer id,Model model)
	{
		List<Stagiaire> stagiaires = personneSrv.getAllStagiaire();
		Stagiaire stagiaire = personneSrv.getStagiaireById(id);
		List<Filiere> filieres = daoFiliere.findAll();
		model.addAttribute("stagiaire", stagiaire);
		model.addAttribute("stagiaires", stagiaires);
		model.addAttribute("filieres",filieres);
		model.addAttribute("civilites",Genre.values());
		return "stagiaires.jsp";
		
	}
	
	@GetMapping("/delete/{id}")
	public String supprimer(@PathVariable Integer id) 
	{
		personneSrv.delete(id);
		return "redirect:/stagiaire";
	}
	
	@PostMapping
	public String ajouter(@ModelAttribute Stagiaire stagiaire) 
	{
		personneSrv.insert(stagiaire);
		return "redirect:/stagiaire";
	}
	
	@PostMapping("/{id}")
	public String modifier(@PathVariable Integer id,@ModelAttribute Stagiaire stagiaire) 
	{
		stagiaire.setId(id);
		personneSrv.update(stagiaire);
		return "redirect:/stagiaire";
	}

}
