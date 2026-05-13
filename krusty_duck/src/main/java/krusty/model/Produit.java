package krusty.model;

import java.util.List;
import java.util.ArrayList;


public class Produit {

	private Integer id;
	private String nom;
	private double prix;
	private int stock;
	private Restaurant restaurant;
	private List<Client> acheteurs = new ArrayList<>();

	//constructeur vide
	public Produit() {}



	//constructeur
	public Produit(String nom, double prix, int stock, Restaurant restaurant) {
		this.nom = nom;
		this.prix = prix;
		this.stock = stock;
		this.restaurant = restaurant;
	}




	// Gestion stock
	public void ajouterStock(int quantite) {
		if (quantite > 0) {
			stock += quantite;
		}
	}

	public boolean retirerStock(int quantite) {
		if (quantite > 0 && stock >= quantite) {
			stock -= quantite;
			return true;
		}
		return false;
	}


	// Clients

	public void ajouterAcheteur(Client client) {
		if (client != null && !acheteurs.contains(client)) {
			acheteurs.add(client);
		}
	}

	public void retirerAcheteur(Client client) {
		acheteurs.remove(client);
	}



	//get set
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

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		if(prix >= 0) {
			this.prix = prix;
		}
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		if(stock >= 0) {
			this.stock = stock;
		}
	}

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	public void setAcheteurs(List<Client> acheteurs) {
		this.acheteurs = acheteurs;
	}

	public List<Client> getAcheteurs() {
		return acheteurs;
	}



	@Override
	public String toString() {
		return "Produit [id=" + id + ", nom=" + nom + ", prix=" + prix + ", stock=" + stock + ", restaurant="
				+ restaurant + "]";
	}


	//toString
	
}
