package demo.model.joined;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
@PrimaryKeyJoinColumn(name="id_tigre")
@Table(name="t_y_es_un_tigre")
public class Tigre extends Animal {

	@Column(name="nom_animal",nullable = false)
	private String nom;

	public Tigre() {}
	
	public Tigre(String couleur, String nom) {
		super(couleur);
		this.nom = nom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	@Override
	public String toString() {
		return "Tigre [id=" + id + ", couleur=" + couleur + ", nom=" + nom + "]";
	}
	
	
}
