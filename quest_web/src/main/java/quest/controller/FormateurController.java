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

import quest.model.Formateur;
import quest.model.Genre;
import quest.service.PersonneService;

@Controller
@RequestMapping("/formateur")
public class FormateurController{

	@Autowired
	PersonneService personneSrv;
	
	
	@GetMapping
	public String chercherTous(Model model)  
	{
		List<Formateur> formateurs = personneSrv.getAllFormateur();
		model.addAttribute("formateur", new Formateur());
		model.addAttribute("formateurs", formateurs);
		model.addAttribute("civilites",Genre.values());
		return "/formateurs.jsp";	
	}
	
	@GetMapping("/{id}")
	public String chercherParId(@PathVariable Integer id,Model model)  
	{
		List<Formateur> formateurs = personneSrv.getAllFormateur();
		Formateur formateur = personneSrv.getFormateurById(id);
		model.addAttribute("formateur", formateur);
		model.addAttribute("formateurs", formateurs);
		model.addAttribute("civilites",Genre.values());
		return "/formateurs.jsp";	
	}
	
	@GetMapping("/delete/{id}")
	public String supprimer(@PathVariable Integer id)  
	{
		personneSrv.delete(id);
		return "redirect:/formateur";
	}
	
	@PostMapping
	public String ajouter(@ModelAttribute Formateur formateur)  
	{
		personneSrv.insert(formateur);
		return "redirect:/formateur";
	}
	
	@PostMapping("/{id}")
	public String modifier(@PathVariable Integer id,@ModelAttribute Formateur formateur)  
	{
		formateur.setId(id);	
		personneSrv.update(formateur);
		return "redirect:/formateur";
	}
}
