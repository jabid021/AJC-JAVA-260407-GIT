package quest.restcontroller;

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

import quest.model.Matiere;
import quest.service.MatiereService;
import quest.view.Views;

@RestController
@RequestMapping("/api/matiere")
public class MatiereRestController {

	@Autowired
	MatiereService matiereSrv;

	@GetMapping("/recherche")
	@JsonView(Views.Matiere.class)
	public List<Matiere> rechercheParLib(String recherche) {
		return matiereSrv.getByLibelleContaining(recherche);
	}

	@GetMapping
	@JsonView(Views.Matiere.class)
	public List<Matiere> chercherTous() {
		return matiereSrv.getAll();
	}

	@GetMapping("/{id}")
	@JsonView(Views.Matiere.class)
	public Matiere chercherParId(@PathVariable Integer id) {
		return matiereSrv.getById(id);
	}

	@DeleteMapping("/{id}")
	public void supprimer(@PathVariable Integer id) {
		matiereSrv.delete(id);
	}

	@PostMapping
	public Matiere ajouter(@RequestBody Matiere matiere) {
		matiereSrv.insert(matiere);
		return matiere;
	}

	@PutMapping("/{id}")
	public Matiere modifier(@PathVariable Integer id, @RequestBody Matiere matiere) {
		matiere.setId(id);
		matiereSrv.update(matiere);
		return matiere;
	}
}
