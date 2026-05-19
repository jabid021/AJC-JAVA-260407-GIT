package demo.model.single;

public class Medecin extends Compte {
 
	private double tarif;
	private String nom;
	
	public Medecin() {}

	public Medecin(String login, String password, double tarif, String nom) {
		super(login, password);
		this.tarif = tarif;
		this.nom = nom;
	}

	public double getTarif() {
		return tarif;
	}

	public void setTarif(double tarif) {
		this.tarif = tarif;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	@Override
	public String toString() {
		return "Medecin [id=" + id + ", login=" + login + ", password=" + password + ", tarif=" + tarif + ", nom=" + nom
				+ "]";
	}
	
	
}
