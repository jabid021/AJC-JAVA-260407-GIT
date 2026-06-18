package eshop.dto;

import java.util.List;

import org.springframework.beans.BeanUtils;

import eshop.model.Fournisseur;
import eshop.model.Genre;

public class FournisseurDTO {

	
	private Integer id;
	private String nom,prenom;
	private Genre civilite;
	private List<ProduitDTO> produits;
	
	
	
	public static FournisseurDTO convert(Fournisseur fournisseur) 
	{
		FournisseurDTO fournisseurDTO = new FournisseurDTO();
		BeanUtils.copyProperties(fournisseur, fournisseurDTO);
		return fournisseurDTO;
	}
	
	public static FournisseurDTO convertWithProduits(Fournisseur fournisseur) 
	{
		FournisseurDTO fournisseurDTO = convert(fournisseur);
		
		fournisseurDTO.produits=fournisseur.getStock().stream().map(p->ProduitDTO.convert(p)).toList();
		return fournisseurDTO;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Genre getCivilite() {
		return civilite;
	}

	public void setCivilite(Genre civilite) {
		this.civilite = civilite;
	}

	public List<ProduitDTO> getProduits() {
		return produits;
	}

	public void setProduits(List<ProduitDTO> produits) {
		this.produits = produits;
	}
	
	
	
}
