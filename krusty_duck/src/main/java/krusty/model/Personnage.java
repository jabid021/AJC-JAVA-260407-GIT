package krusty.model;

import java.util.List;

import jakarta.persistence.Column;
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
@Table(name="personnage")
public abstract class Personnage {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Integer id;
	
	@Column(length = 30, unique = true)
    protected String nom;
	
	@Column(length = 10)
    protected String couleur;
    
    @Enumerated(EnumType.STRING)
    @Column(name="esp" )
    protected Espece espece;
    
    protected transient Lieu habitation;
    
    protected transient List<Humeur> humeurs;
    
    public Personnage() {}
    
    public Personnage(String nom, String couleur, Espece espece,List<Humeur> humeurs) {
        this.nom = nom;
        this.couleur = couleur;
        this.espece = espece;
        this.humeurs=humeurs;
    }
    
    public Personnage(String nom, String couleur, Espece espece,List<Humeur> humeurs,Lieu habitation) {
        this.nom = nom;
        this.couleur = couleur;
        this.espece = espece;
        this.habitation=habitation;
        this.humeurs=humeurs;
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

	public String getCouleur() {
		return couleur;
	}

	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}

	public Espece getEspece() {
		return espece;
	}

	public void setEspece(Espece espece) {
		this.espece = espece;
	}

	public List<Humeur> getHumeurs() {
		return humeurs;
	}

	public void setHumeurs(List<Humeur> humeurs) {
		this.humeurs = humeurs;
	}
    
	
    public Lieu getHabitation() { return habitation; }
    public void setHabitation(Lieu habitation) { this.habitation = habitation; }

    
	@Override
	public String toString() {
		return "Personnage [id=" + id + ", nom=" + nom + ", couleur=" + couleur + ", espece=" + espece + ", habitation="
				+ habitation + ", humeurs=" + humeurs + "]";
	}


    
    

    
}
