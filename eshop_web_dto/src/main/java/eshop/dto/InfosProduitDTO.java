package eshop.dto;

import org.springframework.beans.BeanUtils;
import eshop.model.Produit;

public class InfosProduitDTO {
    private Integer id;
    private String libelle;
    private double prix;

    public static InfosProduitDTO convert(Produit produit) {
        InfosProduitDTO i = new InfosProduitDTO();
        BeanUtils.copyProperties(produit, i);
        return i;
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


}