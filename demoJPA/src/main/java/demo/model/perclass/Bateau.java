package demo.model.perclass;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="boat")
public class Bateau extends Vehicule {

	public Bateau() {}

	public Bateau(int nbRoues, int capacite) {
		super(nbRoues, capacite);
	}

	@Override
	public String toString() {
		return "Bateau [id=" + id + ", nbRoues=" + nbRoues + ", capacite=" + capacite + "]";
	}
	
	
}
