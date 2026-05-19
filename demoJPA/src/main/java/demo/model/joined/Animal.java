package demo.model.joined;

public abstract class Animal {

	protected Integer id;
	protected String couleur;
	
	public Animal() {}
	
	public Animal(String couleur) {
		this.couleur = couleur;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCouleur() {
		return couleur;
	}

	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}
	
	
}
