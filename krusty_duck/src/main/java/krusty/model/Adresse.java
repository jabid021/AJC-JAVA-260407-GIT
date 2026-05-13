package krusty.model;

public class Adresse {
	private String numero;
	private String voie;
	private String ville;
	
	
	public Adresse() {}
	
	public Adresse(String numero, String voie, String ville) {
		this.numero = numero;
		this.voie = voie;
		this.ville = ville;
	}



	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getVoie() {
		return voie;
	}

	public void setVoie(String voie) {
		this.voie = voie;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}
	
	@Override
	public String toString() {
		return "Adresse [numero=" + numero + ", voie=" + voie + ", ville=" + ville + "]";
	}
	
}
