package quest.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity

public class Ordinateur {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer numero;
	@Column(name="marque",nullable=false)
	private String marque;
	@Column(name="ram",nullable=false)
	private int ram;
	@OneToOne
	@JoinColumn(name="id_utilisateur")
	private Stagiaire utilisateur;

	public Ordinateur() {
	}
	
	public Ordinateur(Integer numero, String marque, int ram, Stagiaire utilisateur) {
		this.numero = numero;
		this.marque = marque;
		this.ram = ram;
		this.utilisateur = utilisateur;
	}



	public Stagiaire getUtilisateur() {
		return utilisateur;
	}


	public void setUtilisateur(Stagiaire utilisateur) {
		this.utilisateur = utilisateur;
	}


	public Integer getNumero() {
		return numero;
	}


	public void setNumero(Integer numero) {
		this.numero = numero;
	}


	public String getMarque() {
		return marque;
	}


	public void setMarque(String marque) {
		this.marque = marque;
	}


	public int getRam() {
		return ram;
	}


	public void setRam(int ram) {
		this.ram = ram;
	}

	public String toString() {
		return "Ordinateur [numero=" + numero + ", marque=" + marque + ", ram=" + ram + ", utilisateur=" + utilisateur
				+ "]";
	}
}
