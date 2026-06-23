package fr.formation.repo;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import fr.formation.model.Produit;

public interface ProduitRepository extends JpaRepository<Produit, Integer> {
    public List<Produit> findAllByPrixBetween(BigDecimal x, BigDecimal y);

    // @Query("select p from Produit p where p.prix between ?1 and ?2")
    @Query("select p from Produit p where p.prix between :min and :max")
    public List<Produit> searchByPrixBetween(@Param("min") BigDecimal min, @Param("min") BigDecimal max);
}
