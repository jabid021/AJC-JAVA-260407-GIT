package fr.formation.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.formation.model.Produit;

public interface ProduitDao extends JpaRepository<Produit, Integer> {

}
