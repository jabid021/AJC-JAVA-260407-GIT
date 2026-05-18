package quest.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="ordinateur")
public class Ordinateur {
	@Id
	private Integer numero;
	private String marque;
	private int ram;
	@OneToOne(mappedBy="ordinateur")
	private Stagiaire utilisateur;

	public Ordinateur(Integer numero, String marque, int ram, Stagiaire utilisateur) {
		this.numero = numero;
		this.marque = marque;
		this.ram = ram;
		this.utilisateur = utilisateur;
	}


	public Ordinateur() {}


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
