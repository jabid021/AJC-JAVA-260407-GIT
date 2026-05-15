package eshop.model;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("supplier")
public class Fournisseur extends Personne {
	@Column(name="company",length = 20)
	private String societe;
	
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

	@Override
	public String toString() {
		return "Fournisseur [id=" + id + ", prenom=" + prenom + ", nom=" + nom + ", civilite=" + civilite + ", societe="
				+ societe + "]";
	}
	
}
