package fr.formation.restcontroller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeRestController {
    @GetMapping("/accueil")
    public String accueil() {
        return "Accueil";
    }
}
