package eshop.model;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="type_personne", columnDefinition = "ENUM('customer','supplier')")
@Table(name="person", uniqueConstraints = @UniqueConstraint(columnNames = {"firstname","lastname"}))
public abstract class Personne {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Integer id;
	@Column(name="firstname",length = 20, nullable = false)
	protected String prenom;
	@Column(name="lastname",length = 20, nullable = false)
	protected String nom;
	
	@Enumerated(EnumType.STRING)
	@Column(name="gender", nullable = false)
	protected Genre civilite;
	
	public Personne() {}

	
	public Personne(String prenom, String nom,Genre civilite) {
		this.prenom = prenom;
		this.nom = nom;
		this.civilite=civilite;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	
	public Genre getCivilite() {
		return civilite;
	}

	public void setCivilite(Genre civilite) {
		this.civilite = civilite;
	}
	
	
}
