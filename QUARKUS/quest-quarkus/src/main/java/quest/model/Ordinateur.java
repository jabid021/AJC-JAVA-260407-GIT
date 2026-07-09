package quest.model;

import com.fasterxml.jackson.annotation.JsonView;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Version;

@Entity
@Table(name = "ordinateur")
public class Ordinateur {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer numero;
	@Column(length = 10, nullable = false)
	private String marque;

	private int ram;

	@OneToOne
	@JoinColumn(name = "utilisateur")
	private Stagiaire utilisateur;

	@Version
	private int version;

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

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public String toString() {
		return "Ordinateur [numero=" + numero + ", marque=" + marque + ", ram=" + ram + ", utilisateur=" + utilisateur
				+ "]";
	}
}
