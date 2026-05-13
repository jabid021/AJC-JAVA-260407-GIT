package krusty.model;

import java.util.List;

public class Employe extends Personnage{
	
	private String job;
	private double salaire;
	private Restaurant restaurant;
	
	public Employe() {}
	
	public Employe(String nom, String couleur, Espece espece,List<Humeur> humeurs, String job, double salaire, Restaurant restaurant) {
		super(nom, couleur, espece,humeurs);
		this.job = job;
		this.salaire = salaire;
		this.restaurant = restaurant;
	}

	public Employe(String nom, String couleur, Espece espece,List<Humeur> humeurs,Lieu habitation, String job, double salaire, Restaurant restaurant) {
		super(nom, couleur, espece,humeurs,habitation);
		this.job = job;
		this.salaire = salaire;
		this.restaurant = restaurant;
	}


	public String getJob() {
		return job;
	}


	public void setJob(String job) {
		this.job = job;
	}


	public double getSalaire() {
		return salaire;
	}


	public void setSalaire(double salaire) {
		this.salaire = salaire;
	}


	public Restaurant getRestaurant() {
		return restaurant;
	}


	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	@Override
	public String toString() {
		return "Employe [id=" + id + ", nom=" + nom + ", couleur=" + couleur + ", espece=" + espece + ", habitation="
				+ habitation + ", humeurs=" + humeurs + ", job=" + job + ", salaire=" + salaire + ", restaurant="
				+ restaurant + "]";
	}






}
