package quest.model;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;

@Entity
@DiscriminatorValue("stagiaire")
public class Stagiaire extends Personne {

	@Column(length = 50)
	private String email;
	@Embedded
	private Adresse adresse;
	@ManyToOne
	private Filiere filiere;
	@ManyToOne
	private Ordinateur ordinateur;
	
	public Stagiaire() {}
	
	public Stagiaire(String login, String password, String nom, String prenom, Genre civilite, String email, String numero,String voie,String ville,String cp, Filiere filiere) {
		super(login, password, nom, prenom, civilite);
		this.email = email;
		this.adresse= new Adresse(numero,voie,ville,cp);
		this.filiere=filiere;

	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	public Filiere getFiliere() {
		return filiere;
	}

	public void setFiliere(Filiere filiere) {
		this.filiere = filiere;
	}

	
	public Ordinateur getOrdinateur() {
		return ordinateur;
	}

	public void setOrdinateur(Ordinateur ordinateur) {
		this.ordinateur = ordinateur;
	}

	@Override
	public String toString() {
		return "Stagiaire [id=" + id + ", login=" + login + ", password=" + password + ", nom=" + nom + ", prenom="
				+ prenom + ", civilite=" + civilite + ", email=" + email + ", adresse=" + adresse + ", filiere="
				+ filiere + "]";
	}

	

}