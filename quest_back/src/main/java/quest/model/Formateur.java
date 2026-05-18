package quest.model;

import java.util.List;

public class Formateur extends Personne  {
	private boolean admin;
	private List<Module> affectations;
	
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
