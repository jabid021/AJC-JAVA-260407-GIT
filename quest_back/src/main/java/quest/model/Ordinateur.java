package quest.model;

import org.hibernate.validator.constraints.Range;

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
import jakarta.validation.constraints.NotBlank;
import quest.view.Views;
@Entity
@Table(name="ordinateur")
public class Ordinateur {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonView(Views.Common.class)
	private Integer numero;
	@Column(length = 10,nullable = false)
	@NotBlank(message = "La marque d un pc doit avoir un contenu")
	@JsonView(Views.Common.class)
	private String marque;
	
	@Range(min = 0,max = 64)
	@JsonView(Views.Common.class)
	private int ram;
	
	@OneToOne
	@JoinColumn(name="utilisateur")
	@JsonView(Views.Ordinateur.class)
	private Stagiaire utilisateur;
	
	@Version
	@JsonView(Views.Common.class)
	private int version;

	public Ordinateur() {}
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
