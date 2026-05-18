package quest.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="matiere")
public class Matiere {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String libelle;


	public Matiere(String libelle) 
	{
		this.libelle=libelle;
	}	

	public Matiere() {}

	public void setLibelle(String libelle)
	{
		this.libelle=libelle;
	}

	public String getLibelle()
	{
		return libelle;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String toString() {
		return "Matiere [id=" + id + ", libelle=" + libelle + "]";
	}
}
