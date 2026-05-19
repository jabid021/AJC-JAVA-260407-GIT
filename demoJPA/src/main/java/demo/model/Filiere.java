package demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="filiere")
@SequenceGenerator(sequenceName = "seq_filiere_bdd", name = "seqFiliereCoteJava")
public class Filiere {

	@Id
	// Strategy identity va stocker dans chaque table sa propre value de AutoIncrement
	// Stategy table va generer une table (hibernate_sequence) commune à toutes les entites  qui iront piocher leur id dedans
	// Strategy sequence permet de generer notre PROPRE table d'id, on pourra link plusieurs entity dessus
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqFiliereCoteJava") 
	private Integer id;
	private String libelle;
	
	public Filiere() {}

	public Filiere(String libelle) {
		this.libelle = libelle;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	@Override
	public String toString() {
		return "Filiere [id=" + id + ", libelle=" + libelle + "]";
	}
	
	
}
