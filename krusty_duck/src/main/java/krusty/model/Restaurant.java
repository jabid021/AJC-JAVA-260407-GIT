package krusty.model;

import java.time.LocalTime;
import java.util.List;

import jakarta.persistence.Entity;
@Entity
public class Restaurant extends Lieu {
    private int capacite;
    private LocalTime ouverture;
    private LocalTime fermeture;
    
    
    
    private transient List<Produit> produits;
    private transient List<Employe> employes;
    private transient Patron patron;

    public Restaurant() {
    }

    public Restaurant(String nom, String numero, String voie, String ville, int capacite, LocalTime ouverture, LocalTime fermeture,
             Patron patron) {
        super(nom, numero, voie, ville);
        this.capacite = capacite;
        this.ouverture = ouverture;
        this.fermeture = fermeture;
        this.patron = patron;
    }

    public int getCapacite() {
        return capacite;
    }

    public void setCapacite(int capacite) {
        this.capacite = capacite;
    }

    public LocalTime getOuverture() {
        return ouverture;
    }

    public void setOuverture(LocalTime ouverture) {
        this.ouverture = ouverture;
    }

    public LocalTime getFermeture() {
        return fermeture;
    }

    public void setFermeture(LocalTime fermeture) {
        this.fermeture = fermeture;
    }

    public List<Produit> getProduits() {
        return produits;
    }

    public void setProduits(List<Produit> produits) {
        this.produits = produits;
    }

    public List<Employe> getEmployes() {
        return employes;
    }

    public void setEmployes(List<Employe> employes) {
        this.employes = employes;
    }

    public Patron getPatron() {
        return patron;
    }

    public void setPatron(Patron patron) {
        this.patron = patron;
    }

	@Override
	public String toString() {
		return "Restaurant [id=" + id + ", nom=" + nom + ", adresse=" + adresse + ", personnages=" + personnages
				+ ", capacite=" + capacite + ", ouverture=" + ouverture + ", fermeture=" + fermeture + ", patron="
				+ patron + "]";
	}

   
}