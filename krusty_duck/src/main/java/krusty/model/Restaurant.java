package krusty.model;

import java.time.LocalTime;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
@Entity
public class Restaurant extends Lieu {
    private int capacite;
    private LocalTime ouverture;
    private LocalTime fermeture;
    
    //One / @Many
   
    //Pour relier 2 classes entre elles @XToY:  
    //X => un patron dirige combien de restaurant ?
    //Y=> Combien de patron dans le restaurant
    @OneToOne 
    private Patron patron;
    
    
    
    private transient List<Produit> produits;
    private transient List<Employe> employes;


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