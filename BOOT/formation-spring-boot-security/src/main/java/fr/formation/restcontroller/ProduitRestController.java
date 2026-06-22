package fr.formation.restcontroller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/produit")
public class ProduitRestController {
    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    public String findAll() {
        return "Find All Produits";
    }
}
