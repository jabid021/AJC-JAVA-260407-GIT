package quest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import quest.model.Matiere;
import quest.service.MatiereService;

@Controller
@RequestMapping("/matiere")
public class MatiereController{

	@Autowired
	MatiereService matiereSrv;
	
	
	
	@GetMapping("/recherche")
	@ResponseBody //Permet d'envoyer du contenu brut et non une redirection (forward/redirect)
	public String rechercheParLib(String recherche)  
	{
		List<Matiere> matieres = matiereSrv.getByLibelleContaining(recherche);
		String affichage = "";
		if(matieres.isEmpty()) 
		{
			affichage="<tr><td colspan='100%' align='center'>Aucune Matiere</td></tr>";
		}
		for(Matiere m : matieres) 
		{
			affichage+="<tr>";
			affichage+="<td>"+m.getId()+"</td>";
			affichage+="<td>"+m.getLibelle()+"</td>";
			affichage+="<td>";
			affichage+="<a href='matiere?id="+m.getId()+"' class='btn btn-warning'>Modifier</a>";
			affichage+="<a href='matiere?id="+m.getId()+"&delete' class='btn btn-danger'>Supprimer</a>";
			affichage+="</td>";
			affichage+="</tr>";
		}
		return affichage;
	}
	
	@GetMapping
	public String chercherTous(Model model)  
	{
		List<Matiere> matieres = matiereSrv.getAll();
		model.addAttribute("matiere", new Matiere());
		model.addAttribute("matieres", matieres);
		return "matieres.jsp";	
	}
	
	@GetMapping("/{id}")
	public String chercherParId(@PathVariable Integer id,Model model)  
	{
		List<Matiere> matieres = matiereSrv.getAll();
		Matiere matiere = matiereSrv.getById(id);
		model.addAttribute("matiere", matiere);
		model.addAttribute("matieres", matieres);
		return "matieres.jsp";
	}
	
	@GetMapping("/delete/{id}")
	public String supprimer(@PathVariable Integer id)  
	{
		matiereSrv.delete(id);
		return "redirect:/matiere";
	}
	
	@PostMapping
	public String ajouter(String libelle)  
	{
		Matiere matiere = new Matiere(null, libelle);
		matiereSrv.insert(matiere);
		return "redirect:/matiere";
	}
	
	@PostMapping("/{id}")
	public String modifier(@PathVariable Integer id,String libelle)  
	{
		Matiere matiere = new Matiere(id, libelle);
		matiereSrv.update(matiere);
		return "redirect:/matiere";
	}
}
