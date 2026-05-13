package krusty.model;

import java.util.List;

public class Client extends Personnage{

	
	private List<Produit> produits;
	
	public Client(String nom, String couleur, Espece espece,List<Humeur> humeurs) {
		super(nom, couleur, espece,humeurs);
	}
	
	public Client(String nom, String couleur, Espece espece,List<Humeur> humeurs, Lieu habitation) {
		super(nom, couleur, espece,humeurs,habitation);
	}
	
	public List<Produit> getProduits() {
		return produits;
	}



	public void setProduits(List<Produit> produits) {
		this.produits = produits;
	}



	@Override
	public String toString() {
		return "Client [nom=" + nom + ", couleur=" + couleur + ", espece=" + espece + ", humeurs="
				+ humeurs + "]";
	}

}
