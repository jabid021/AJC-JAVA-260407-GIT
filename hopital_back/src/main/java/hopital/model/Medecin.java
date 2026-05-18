package hopital.model;

import java.util.ArrayList;
import java.util.List;

public class Medecin extends Compte{

	
	private int salle;
	private List<Visite> consultations = new ArrayList();
	
	
	
	public Medecin(Integer id, String login, String password) {
		super(id, login, password);
	}

	public int getSalle() {
		return salle;
	}

	public void setSalle(int salle) {
		this.salle = salle;
	}

	public List<Visite> getConsultations() {
		return consultations;
	}

	public void setConsultations(List<Visite> consultations) {
		this.consultations = consultations;
	}

	@Override
	public String toString() {
		return "Medecin [id=" + id + ", login=" + login + ", password=" + password + ", salle=" + salle + "]";
	}
	
	
}
