package demo.model.joined;

import jakarta.persistence.Entity;

@Entity
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
