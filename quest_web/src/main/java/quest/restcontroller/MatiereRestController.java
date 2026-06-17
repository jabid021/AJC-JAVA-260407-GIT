package quest.restcontroller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import quest.model.Matiere;

@RestController
@RequestMapping("/api/matiere")
public class MatiereRestController {

	
	
	@GetMapping("/{page}")
	public Matiere demo(@RequestParam String login, @PathVariable (name="page")Integer nbPage) 
	{
		System.out.println("login : "+login);
		System.out.println("page : "+nbPage);
		return new Matiere(1,"Math");
	}
}
