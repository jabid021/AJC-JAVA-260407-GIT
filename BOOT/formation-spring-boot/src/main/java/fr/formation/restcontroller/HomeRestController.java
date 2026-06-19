package fr.formation.restcontroller;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeRestController {
    @GetMapping("/accueil")
    public Map<String, String> accueil() {
        System.out.println("COUCOU");
        return Map.of("attr1", "valeur1", "attr2", "valeur2");
    }
}
