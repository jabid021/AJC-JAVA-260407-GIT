package krusty.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="vente")
public class Vente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private Integer id;
	@Column(name="date_vente",nullable=false)
	private LocalDateTime dateVente;
	private int quantite;
	
	@JoinColumn(name="produit",nullable = false)
	@ManyToOne
	private Produit produit;
	
	@JoinColumn(name="acheteur",nullable = false)
	@ManyToOne
	private Client client;
	
	public Vente() {}

	public Vente(int quantite, Produit produit, Client client) {
		this.quantite = quantite;
		this.produit = produit;
		this.client = client;
		this.dateVente=LocalDateTime.now();
	}
	
	public Vente(int quantite, Produit produit, Client client,LocalDateTime dateVente) {
		this.quantite = quantite;
		this.produit = produit;
		this.client = client;
		this.dateVente=dateVente;
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDateTime getDateVente() {
		return dateVente;
	}

	public void setDateVente(LocalDateTime dateVente) {
		this.dateVente = dateVente;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public Produit getProduit() {
		return produit;
	}

	public void setProduit(Produit produit) {
		this.produit = produit;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	@Override
	public String toString() {
		return "Vente [id=" + id + ", dateVente=" + dateVente + ", quantite=" + quantite + ", produit=" + produit
				+ ", client=" + client + "]";
	}

	
}
