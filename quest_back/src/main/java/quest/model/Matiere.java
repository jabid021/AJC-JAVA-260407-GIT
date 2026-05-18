package quest.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "matiere")
public class Matiere {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(length = 40)
	private String libelle;


	
	//constructeur vide
	public Matiere() {}
	
	//constructeur
	public Matiere(Integer id, String libelle) 
	{
		this.id=id;
		this.libelle=libelle;
	}	

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
