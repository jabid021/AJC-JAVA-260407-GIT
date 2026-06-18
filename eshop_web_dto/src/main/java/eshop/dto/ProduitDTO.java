package eshop.dto;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import eshop.model.Produit;

public class ProduitDTO {

	private Integer id;
	private String libelle;
	private double prix;
	private Integer idFournisseur;
	private String nomFournisseur;
	private List<VenteDTO> ventesCustom=new ArrayList();
	

	public static ProduitDTO convert(Produit produit) 
	{
		ProduitDTO p = new ProduitDTO();
		BeanUtils.copyProperties(produit, p);
		p.idFournisseur=produit.getFournisseur().getId();
		p.nomFournisseur=produit.getFournisseur().getNom();
		return p;
	}
	
	
	public static ProduitDTO convertWithVentes(Produit produit) 
	{
		ProduitDTO p = convert(produit);
		p.ventesCustom=produit.getVentes().stream().map(achat->VenteDTO.convert(achat)).toList();
		return p;
	}
	

	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public String getLibelle() {
		return libelle;
	}



	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}



	public double getPrix() {
		return prix;
	}



	public void setPrix(double prix) {
		this.prix = prix;
	}



	public Integer getIdFournisseur() {
		return idFournisseur;
	}



	public void setIdFournisseur(Integer idFournisseur) {
		this.idFournisseur = idFournisseur;
	}



	public String getNomFournisseur() {
		return nomFournisseur;
	}



	public void setNomFournisseur(String nomFournisseur) {
		this.nomFournisseur = nomFournisseur;
	}


	public List<VenteDTO> getVentesCustom() {
		return ventesCustom;
	}


	public void setVentesCustom(List<VenteDTO> ventesCustom) {
		this.ventesCustom = ventesCustom;
	}
	
	
	
}
