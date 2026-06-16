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

import quest.dao.IDAOSalle;
import quest.model.Salle;


@Controller
@RequestMapping("/salle")
public class SalleController {

	@Autowired
	IDAOSalle daoSalle;
	
	@GetMapping
	public String chercherTous(Model model)
	{
		List<Salle> salles = daoSalle.findAllWithHistorique();
		model.addAttribute("salle", new Salle());
		model.addAttribute("salles", salles);
		return ("salles.jsp");	
	}
	
	
	@GetMapping("/{id}")
	public String chercherParId(@PathVariable Integer id,Model model)
	{
		List<Salle> salles = daoSalle.findAllWithHistorique();
		Salle salle = daoSalle.findById(id).orElse(null);

		model.addAttribute("salle", salle);
		model.addAttribute("salles", salles);
		
		return "salles.jsp";
		
	}
	
	@GetMapping("/delete/{id}")
	public String supprimer(@PathVariable Integer id) 
	{
		daoSalle.deleteById(id);
		return "redirect:/salle";
		
	}
	
	@PostMapping
	public String ajouter(@ModelAttribute Salle salle) 
	{
		daoSalle.save(salle);
		return "redirect:/salle";
	}
	
	@PostMapping("/{id}")
	public String modifier(@PathVariable Integer id,@ModelAttribute Salle salle) 
	{
		salle.setId(id);
		daoSalle.save(salle);
		return "redirect:/salle";
	}
	
	/*@PostMapping
	public String ajouter(String nom, @RequestParam(name="adresse.numero") String numero,@RequestParam(name="adresse.voie") String voie,@RequestParam(name="adresse.cp") String cp,@RequestParam(name="adresse.ville") String ville) 
	{
		Salle salle = new Salle(null, nom, numero, voie, ville, cp);
		daoSalle.save(salle);
		
		return "redirect:/salle";
	}*/
	
	/*@PostMapping("/{id}")
	public String modifier(@PathVariable Integer id,String nom, @RequestParam(name="adresse.numero") String numero,@RequestParam(name="adresse.voie") String voie,@RequestParam(name="adresse.cp") String cp,@RequestParam(name="adresse.ville") String ville) 
	{
		Salle salle = new Salle(id, nom, numero, voie, ville, cp);
		daoSalle.save(salle);
		
		return "redirect:/salle";
	}*/

}
