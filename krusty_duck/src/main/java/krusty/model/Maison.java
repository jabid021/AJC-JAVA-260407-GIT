package krusty.model;

public class Maison extends Lieu {
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
		return "Maison [id=" + id + ", nom=" + nom + ", adresse=" + adresse + ", personnages=" + personnages
				+ ", forme=" + forme + "]";
	}
	
}
