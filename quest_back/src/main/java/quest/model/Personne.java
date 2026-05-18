package quest.model;

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

@Entity
@Inheritance(strategy =InheritanceType.SINGLE_TABLE)
@Table(name="personne")
@DiscriminatorColumn(name = "type_perso",columnDefinition = "ENUM('stagiaire','formateur')")
public abstract class Personne {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Integer id;
	@Column(length = 30, unique = true)
	protected String login;
	@Column(length = 30, unique = true)
	protected String password;
	@Column(length = 30, unique = false)
	protected String nom;
	@Column(length = 30, unique = false)
	protected String prenom;
    @Enumerated(EnumType.STRING)
    @Column(name="genre",nullable = false)
	protected Genre civilite;

	public Personne() {}

	public Personne(String login, String password, String nom, String prenom, Genre civilite) {
		this.login = login;
		this.password = password;
		this.civilite = civilite;
		this.nom = nom;
		this.prenom = prenom;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}


	public Genre getCivilite() {
		return civilite;
	}


	public void setCivilite(Genre civilite) {
		this.civilite = civilite;
	}
	
}

