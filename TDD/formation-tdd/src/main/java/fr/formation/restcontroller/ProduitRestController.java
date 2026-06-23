package fr.formation.restcontroller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.formation.model.Produit;
import fr.formation.repo.ProduitRepository;

@RestController
@RequestMapping("/api/produit")
public class ProduitRestController {
    @Autowired
    private ProduitRepository repository;

    @GetMapping
    public List<Produit> findAll() {
        return this.repository.findAll();
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable int id) {
        this.repository.deleteById(id);
    }

    @DeleteMapping("/2/{id}")
    public Integer deleteById2(@PathVariable int id) {
        this.repository.deleteById(id);

        return id;
    }

    @DeleteMapping("/3/{id}")
    public Produit deleteById3(@PathVariable int id) {
        Optional<Produit> optProduit = this.repository.findById(id);

        if (optProduit.isPresent()) {
            this.repository.delete(optProduit.get());

            return optProduit.get();
        }

        return null;
    }
}
