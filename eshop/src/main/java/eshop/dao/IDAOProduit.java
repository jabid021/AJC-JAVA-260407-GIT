package eshop.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import eshop.model.Produit;

public interface IDAOProduit extends JpaRepository<Produit,Integer> {

	@Query("SELECT p from Produit p where p.libelle like :recherche")
	public List<Produit> findByLibLike(@Param("recherche") String libelle);
	public List<Produit> findByLibelleLike( String libelle);
	
	
	public List<Produit> findByLibelleContaining(String libelle);
	
	
	@Query("SELECT p from Produit p where p.libelle = :recherche")
	public List<Produit> findParLib(@Param("recherche") String libelle);
	public List<Produit> findByLibelle(String libelle);
	
	
	public List<Produit> findByPrixBetween(double min,double max);
	
	public List<Produit> findByPrixLessThan(double prix);
	
	@Query("SELECT p from Produit p LEFT JOIN FETCH p.ventes where p.id=:idProduit")
	public Produit findByIdWithVentes(@Param("idProduit") Integer idProduit);

}
