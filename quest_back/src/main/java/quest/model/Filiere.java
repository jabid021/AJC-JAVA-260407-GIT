package quest.model;

import java.time.LocalDate;
import java.util.List;

public class Filiere {
	private Integer id;
	private String libelle;  

	private LocalDate debut; 
	private LocalDate fin;
	private Salle salle; 
	private List<Stagiaire> stagiaires;
	private List<Module> cours;

	public Filiere(Integer id, String libelle, LocalDate debut, LocalDate fin, Salle salle) {
		this.id = id;
		this.libelle = libelle;
		this.debut = debut;
		this.fin = fin;
		this.salle = salle;
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


	public LocalDate getDebut() {
		return debut;
	}


	public void setDebut(LocalDate debut) {
		this.debut = debut;
	}

	public LocalDate getFin() {
		return fin;
	}

	public void setFin(LocalDate fin) {
		this.fin = fin;
	}


	public Salle getSalle() {
		return salle;
	}

	public void setSalle(Salle salle) {
		this.salle = salle;
	}


	
	public List<Stagiaire> getStagiaires() {
		return stagiaires;
	}


	public void setStagiaires(List<Stagiaire> stagiaires) {
		this.stagiaires = stagiaires;
	}

	

	public List<Module> getCours() {
		return cours;
	}


	public void setCours(List<Module> cours) {
		this.cours = cours;
	}


	@Override
	public String toString() {
		return "Filiere [id=" + id + ", libelle=" + libelle + ", debut=" + debut + ", fin=" + fin + ", salle=" + salle
				+ "]";
	}
	
	
	


}
