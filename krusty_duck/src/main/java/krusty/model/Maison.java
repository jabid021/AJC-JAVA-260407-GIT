package krusty.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class Maison extends Lieu {
	@Column(length = 20)
	private String forme;

	public Maison() {}
	
	public Maison(String nom, String numero, String voie, String ville, String forme) {
		super(nom, numero, voie, ville);
		this.forme = forme;
	}



	public String getForme() {
		return forme;
	}

	public void setForme(String forme) {
		this.forme = forme;
	}

	@Override
	public String toString() {
		return "Maison [id=" + id + ", nom=" + nom + ", adresse=" + adresse + ", forme=" + forme + "]";
	}
	
}
