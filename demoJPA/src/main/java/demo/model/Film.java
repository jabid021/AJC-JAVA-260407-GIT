package demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="film")
public class Film {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqFiliereCoteJava") 
	private Integer id;
	private String nom;
	
	public Film() {}

	
	public Film(String nom) {
		this.nom = nom;
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


	@Override
	public String toString() {
		return "Film [id=" + id + ", nom=" + nom + "]";
	}
	
	
}
