package fr.formation.restcontroller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/produit")
public class ProduitRestController {
    @GetMapping
    // hasRole('ADMIN') et hasAuthority('ROLE_ADMIN') => exactement la même chose
    @PreAuthorize("hasRole('ADMIN')")
    // @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    // @PreAuthorize("hasAuthority('PRODUCT_READ')")
    public String findAll() {
        return "Find All Produits";
    }
}
