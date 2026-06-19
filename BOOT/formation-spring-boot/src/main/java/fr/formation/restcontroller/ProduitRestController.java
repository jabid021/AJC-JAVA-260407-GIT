package fr.formation.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.formation.dao.ProduitDao;
import fr.formation.model.Produit;

@RestController
@RequestMapping("/api/produit")
public class ProduitRestController {
    // @Autowired
    // private ProduitDao daoProduit;

    private final ProduitDao daoProduit;

    public ProduitRestController(ProduitDao daoProduit) {
        this.daoProduit = daoProduit;
    }

    @GetMapping
    public List<Produit> findAll() {
        return this.daoProduit.findAll();
    }

    @PostMapping
    public Produit create(@RequestBody Produit produit) {
        this.daoProduit.save(produit);

        return produit;
    }
}
