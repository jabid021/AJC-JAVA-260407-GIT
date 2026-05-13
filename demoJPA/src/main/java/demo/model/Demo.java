package demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity //Obligatoire => Permet de generer une table "demo"
public class Demo {

	@Id //Obligatoire => Permet de preciser quelle col est la pk
	@GeneratedValue(strategy = GenerationType.IDENTITY)   //Semi-obligatoire => Permet d'active l'auto increment
	private Integer id;
	private String libelle;
	private boolean resultat;
	
	//Obligatoire d'avoir un constructeur vide
	public Demo() {}
	
	
	public Demo(String libelle, boolean resultat) {
		this.libelle = libelle;
		this.resultat = resultat;
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


	public boolean isResultat() {
		return resultat;
	}


	public void setResultat(boolean resultat) {
		this.resultat = resultat;
	}


	@Override
	public String toString() {
		return "Demo [id=" + id + ", libelle=" + libelle + ", resultat=" + resultat + "]";
	}
	
	
	
	
	
	
	

}
