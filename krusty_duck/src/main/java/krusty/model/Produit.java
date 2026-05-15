package krusty.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="product")
public class Produit {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_produit")
	private Integer id;
	@Column(name="label",length = 45,nullable = false)
	private String nom;
	@Column(columnDefinition = "DECIMAL(5,2)")
	private double prix;
	private int stock;
	
	
	@ManyToOne
	@JoinColumn(name="restaurant")
	private Restaurant restaurant;
	
	//Pour lier un produit avec un client (chaque vente) => 2 id
	//Id principal (celui de gauche en bdd, id de la classe ou on se trouve, ici Produit) => joinColumn
	//Id secondaire (celui de droite en bdd, l'autre classe, ici Client => inverseJoinColumn
	@OneToMany(mappedBy="produit")
	/*@JoinTable
	   (
			name="ventes", //rename la table de jointure
			joinColumns = @JoinColumn(name="produit"), //rename la colonne de gauche
			inverseJoinColumns = @JoinColumn(name="acheteur") //rename la colonne de droite 
			//,uniqueConstraints = @UniqueConstraint(columnNames = {"produit","acheteur"})	
		)*/
	private List<Vente> ventes = new ArrayList<>();

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




	//get set
	public Integer getId() {
		return id;
	}

	public List<Vente> getVentes() {
		return ventes;
	}



	public void setVentes(List<Vente> ventes) {
		this.ventes = ventes;
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
	
//toString
	@Override
	public String toString() {
		return "Produit [id=" + id + ", nom=" + nom + ", prix=" + prix + ", stock=" + stock + ", restaurant="
				+ restaurant + "]";
	}


	
	
}
