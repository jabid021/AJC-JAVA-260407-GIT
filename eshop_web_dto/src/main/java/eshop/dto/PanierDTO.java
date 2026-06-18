package eshop.dto;

public class PanierDTO {

	private Integer client;
	private Integer produit;
	private Integer quantite;
	
	public PanierDTO() {}

	public Integer getClient() {
		return client;
	}

	public void setClient(Integer client) {
		this.client = client;
	}

	public Integer getProduit() {
		return produit;
	}

	public void setProduit(Integer produit) {
		this.produit = produit;
	}

	public Integer getQuantite() {
		return quantite;
	}

	public void setQuantite(Integer quantite) {
		this.quantite = quantite;
	}
	
	
	
}
