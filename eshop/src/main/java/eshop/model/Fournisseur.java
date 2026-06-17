package eshop.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

@Entity
@DiscriminatorValue("supplier")
public class Fournisseur extends Personne {
	@Column(name="company",length = 20)
	private String societe;
	
	@OneToMany(mappedBy = "fournisseur")
	private List<Produit> stock;
	
	
	public Fournisseur() {}

	public Fournisseur(String prenom, String nom, Genre civilite, String societe) {
		super(prenom, nom, civilite);
		this.societe = societe;
	}

	public String getSociete() {
		return societe;
	}

	public void setSociete(String societe) {
		this.societe = societe;
	}
	
	

	public List<Produit> getStock() {
		return stock;
	}

	public void setStock(List<Produit> stock) {
		this.stock = stock;
	}

	public String getInfosSelect() 
	{
		return id+" - "+prenom+" "+nom;
	}
	
	@Override
	public String toString() {
		return "Fournisseur [id=" + id + ", prenom=" + prenom + ", nom=" + nom + ", civilite=" + civilite + ", societe="
				+ societe + "]";
	}
	
}
