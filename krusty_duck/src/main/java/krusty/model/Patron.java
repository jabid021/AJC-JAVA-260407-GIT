package krusty.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("boss")
public class Patron  extends Personnage{

	@Column(columnDefinition ="DECIMAL(15,2)")
	private double fortune;





	private transient Restaurant restaurant;



	public Patron() {}
	
	public Patron(String nom, String couleur, Espece espece,List<Humeur> humeurs, double fortune) {
		super(nom, couleur, espece,humeurs);
		this.fortune = fortune;
	}

	public Patron(String nom, String couleur, Espece espece,List<Humeur> humeurs, double fortune,Lieu habitation) {
		super(nom, couleur, espece,humeurs);
		this.fortune = fortune;
		this.habitation=habitation;
	}


	public double getFortune() {
		return fortune;
	}

	public void setFortune(double fortune) {
		this.fortune = fortune;
	}


	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	@Override
	public String toString() {
		return "Patron [id=" + id + ", nom=" + nom + ", couleur=" + couleur + ", espece=" + espece + ", habitation="
				+ habitation + ", humeurs=" + humeurs + ", fortune=" + fortune + "]";
	}




}
