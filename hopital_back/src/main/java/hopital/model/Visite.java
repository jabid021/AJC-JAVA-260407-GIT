package hopital.model;

import java.time.LocalDate;

public class Visite {

	private Integer numero;
	private Patient patient;
	private Medecin medecin;
	private LocalDate dateVisite;
	private double prix;
	private int salle;
	
	public Visite(Integer numero, Patient patient, Medecin medecin, LocalDate dateVisite, double prix, int salle) {
		this.numero = numero;
		this.patient = patient;
		this.medecin = medecin;
		this.dateVisite = dateVisite;
		this.prix = prix;
		this.salle = salle;
	}

	public Visite(Patient patient, Medecin medecin) {
		this.patient = patient;
		this.medecin = medecin;
		this.dateVisite = LocalDate.now();
		this.prix = 20;
		this.salle = medecin.getSalle();
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public Medecin getMedecin() {
		return medecin;
	}

	public void setMedecin(Medecin medecin) {
		this.medecin = medecin;
	}

	public LocalDate getDateVisite() {
		return dateVisite;
	}

	public void setDateVisite(LocalDate dateVisite) {
		this.dateVisite = dateVisite;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public int getSalle() {
		return salle;
	}

	public void setSalle(int salle) {
		this.salle = salle;
	}

	@Override
	public String toString() {
		return "Visite [numero=" + numero + ", patient=" + patient + ", medecin=" + medecin.getId() + ", dateVisite=" + dateVisite
				+ ", prix=" + prix + ", salle=" + salle + "]";
	}
	
	
	
	
}
