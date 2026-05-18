package quest.model;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
@DiscriminatorValue("Stagiaire")
public class Stagiaire extends Personne {

	@Column(length = 50,nullable=true)
	private String email;
	@Embedded
	private Adresse adresse;
	@ManyToOne
	private Filiere filiere;
	@OneToOne(mappedBy ="utilisateur")
	private Ordinateur ordinateur;
	
	public Stagiaire(Integer id, String login, String password, String nom, String prenom, Genre civilite, String email, String numero,String voie,String ville,String cp, Filiere filiere) {
		super(id, login, password, nom, prenom, civilite);
		this.email = email;
		this.adresse= new Adresse(numero,voie,ville,cp);
		this.filiere=filiere;

	}
	
	public Stagiaire() {}

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