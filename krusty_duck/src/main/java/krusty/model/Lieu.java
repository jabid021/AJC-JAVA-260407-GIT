package krusty.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Inheritance(strategy =InheritanceType.SINGLE_TABLE)
@Table(name="lieu")
@DiscriminatorColumn(name="type_lieu")
public abstract class Lieu {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Integer id;
	
	@Column(length = 40,nullable = false)
	protected String nom;
	@Embedded
	protected  Adresse adresse;
	
	
	
	
	@OneToMany(mappedBy = "habitation")
	protected List<Personnage> personnages;
	

	public Lieu() {}
	
	public Lieu(String nom, String numero, String voie, String ville) {
		this.nom = nom;
		this.adresse = new Adresse(numero, voie, ville);
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
	
	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	public List<Personnage> getPersonnages() {
		return personnages;
	}

	public void setPersonnages(List<Personnage> personnages) {
		this.personnages = personnages;
	}

}
