package krusty.model;

import java.util.List;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("customer")
public class Client extends Personnage{

	
	private transient List<Vente> achats;
	
	
	
	
	
	public Client(String nom, String couleur, Espece espece,List<Humeur> humeurs) {
		super(nom, couleur, espece,humeurs);
	}
	
	public Client(String nom, String couleur, Espece espece,List<Humeur> humeurs, Lieu habitation) {
		super(nom, couleur, espece,humeurs,habitation);
	}

	public List<Vente> getAchats() {
		return achats;
	}

	public void setAchats(List<Vente> achats) {
		this.achats = achats;
	}

	@Override
	public String toString() {
		return "Client [nom=" + nom + ", couleur=" + couleur + ", espece=" + espece + ", humeurs="
				+ humeurs + "]";
	}

}
