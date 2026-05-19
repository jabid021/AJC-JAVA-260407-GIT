package demo.model.perclass;

public abstract class Vehicule {
	
	protected Integer id;
	protected int nbRoues;
	protected int capacite;
	
	public Vehicule() {}
	
	public Vehicule(int nbRoues, int capacite) {
		this.nbRoues = nbRoues;
		this.capacite = capacite;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getNbRoues() {
		return nbRoues;
	}

	public void setNbRoues(int nbRoues) {
		this.nbRoues = nbRoues;
	}

	public int getCapacite() {
		return capacite;
	}

	public void setCapacite(int capacite) {
		this.capacite = capacite;
	}
	
	
	

}
