package quest.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;

@Entity
public class Salle {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(length=20)
	private String nom;
	@JoinColumn(nullable=false)
	private Adresse adresse;
	
	public Salle(Integer id, String nom,String numero, String voie, String ville, String cp) {
		this.id = id;
		this.nom = nom;
		this.adresse = new Adresse(numero,voie,ville,cp);
	}
	

	public Salle() {
		super();
	}



	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}

	public String toString() {
		return "Salle [id=" + id + ", nom=" + nom + ", adresse=" + adresse + "]";
	}
	
}

