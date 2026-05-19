package demo.model.joined;

import jakarta.persistence.Entity;

@Entity
public class Lion extends Animal{

	private boolean king;

	public Lion() {}
	
	public Lion(String couleur, boolean king) {
		super(couleur);
		this.king = king;
	}

	public boolean isKing() {
		return king;
	}

	public void setKing(boolean king) {
		this.king = king;
	}

	@Override
	public String toString() {
		return "Lion [id=" + id + ", couleur=" + couleur + ", king=" + king + "]";
	}
	
	
}
