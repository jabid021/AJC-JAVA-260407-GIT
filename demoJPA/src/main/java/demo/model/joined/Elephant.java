package demo.model.joined;

public class Elephant extends Animal{

	public Elephant() {}

	public Elephant(String couleur) {
		super(couleur);
	}

	@Override
	public String toString() {
		return "Elephant [id=" + id + ", couleur=" + couleur + "]";
	}
	
	
}
