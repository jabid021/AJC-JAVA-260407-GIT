package demo.model.perclass;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="car")
public class Voiture extends Vehicule {

	
	private boolean essence;

	public Voiture() {}

	public Voiture(int nbRoues, int capacite, boolean essence) {
		super(nbRoues, capacite);
		this.essence = essence;
	}

	public boolean isEssence() {
		return essence;
	}

	public void setEssence(boolean essence) {
		this.essence = essence;
	}

	@Override
	public String toString() {
		return "Voiture [id=" + id + ", nbRoues=" + nbRoues + ", capacite=" + capacite + ", essence=" + essence + "]";
	}
	
	
	
}
