package quest.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonView;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import quest.view.Views;

@Entity
public class Formateur extends Personne  {
	@JsonView(Views.Common.class)
	private boolean admin;
	
	@OneToMany(mappedBy = "formateur")
	@JsonView(Views.FormateurWithModules.class)
	private List<Module> affectations;
	
	public Formateur() {}
	
	public Formateur(Integer id, String login, String password, String nom, String prenom, Genre civilite, boolean admin) {
		super(id, login, password, nom, prenom, civilite);
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
