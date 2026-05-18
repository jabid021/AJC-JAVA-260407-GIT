package quest.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

@Entity
@DiscriminatorValue("formateur")
public class Formateur extends Personne  {
	@Column(name = "admin")
	private boolean admin;
	@OneToMany(mappedBy = "formateur")
	private List<Module> affectations;
	
	public Formateur() {}
	
	public Formateur(String login, String password, String nom, String prenom, Genre civilite, boolean admin) {
		super(login, password, nom, prenom, civilite);
		this.admin = admin;
	}

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	
	public List<Module> getAffectations() {
		return affectations;
	}

	public void setAffectations(List<Module> affectations) {
		this.affectations = affectations;
	}

	@Override
	public String toString() {
		return "Formateur [id=" + id + ", login=" + login + ", password=" + password + ", nom=" + nom + ", prenom="
				+ prenom + ", civilite=" + civilite + ", admin=" + admin + "]";
	}


	
	
}
