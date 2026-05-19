package demo.model.joined;

public class Tigre extends Animal {

	private String nom;

	public Tigre() {}
	
	public Tigre(String couleur, String nom) {
		super(couleur);
		this.nom = nom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	@Override
	public String toString() {
		return "Tigre [id=" + id + ", couleur=" + couleur + ", nom=" + nom + "]";
	}
	
	
}
