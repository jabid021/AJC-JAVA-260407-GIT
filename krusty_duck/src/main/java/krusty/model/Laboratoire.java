package krusty.model;

import jakarta.persistence.Entity;

@Entity
public class Laboratoire extends Lieu{
	private boolean secret;

	public Laboratoire() {}
	
	public Laboratoire(String nom, String numero, String voie, String ville, boolean secret) {
		super(nom, numero, voie, ville);
		this.secret = secret;
	}

	public boolean isSecret() {
		return secret;
	}

	public void setSecret(boolean secret) {
		this.secret = secret;
	}

	@Override
	public String toString() {
		return "Laboratoire [id=" + id + ", nom=" + nom + ", adresse=" + adresse + ", personnages=" + personnages
				+ ", secret=" + secret + "]";
	}

	


}
	
