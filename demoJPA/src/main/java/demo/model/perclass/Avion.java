package demo.model.perclass;

public class Avion extends Vehicule {

	private String compagnie;
	
	public Avion() {}

	public Avion(int nbRoues, int capacite, String compagnie) {
		super(nbRoues, capacite);
		this.compagnie = compagnie;
	}

	public String getCompagnie() {
		return compagnie;
	}

	public void setCompagnie(String compagnie) {
		this.compagnie = compagnie;
	}

	@Override
	public String toString() {
		return "Avion [id=" + id + ", nbRoues=" + nbRoues + ", capacite=" + capacite + ", compagnie=" + compagnie + "]";
	}
	
}
