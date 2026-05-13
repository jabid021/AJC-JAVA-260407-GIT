package krusty.model;

import java.util.List;

public class Patron  extends Personnage{
	
	private double fortune;
	private Restaurant restaurant;

	public Patron(String nom, String couleur, Espece espece,List<Humeur> humeurs, double fortune) {
		super(couleur, couleur, espece,humeurs);
		this.fortune = fortune;
	}
	
	public Patron(String nom, String couleur, Espece espece,List<Humeur> humeurs, double fortune,Lieu habitation) {
		super(couleur, couleur, espece,humeurs);
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
