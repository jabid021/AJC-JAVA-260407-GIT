package krusty.model;

import java.util.List;

public abstract class Lieu {
	
	protected Integer id;
	protected String nom;
	protected Adresse adresse;
	protected List<Personnage> personnages;
	

	public Lieu() {}
	
	public Lieu(String nom, String numero, String voie, String ville) {
		this.nom = nom;
		this.adresse = new Adresse(numero, voie, ville);
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
	
	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	public List<Personnage> getPersonnages() {
		return personnages;
	}

	public void setPersonnages(List<Personnage> personnages) {
		this.personnages = personnages;
	}

}
