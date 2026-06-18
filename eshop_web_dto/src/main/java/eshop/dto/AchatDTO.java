package eshop.dto;

import java.time.LocalDate;

import org.springframework.beans.BeanUtils;

import com.fasterxml.jackson.annotation.JsonFormat;

import eshop.model.Achat;

public class AchatDTO {

	private Integer id;
	@JsonFormat(pattern="yyyy-MM-dd")
	private LocalDate dateAchat;
	private int quantite;
	private Integer idProduit;
	private double prixProduit;
	private String libelleProduit;
	
	
	
	public static AchatDTO convert(Achat achat) 
	{
		AchatDTO a = new AchatDTO();
		BeanUtils.copyProperties(achat,a);
		a.idProduit=achat.getProduit().getId();
		a.prixProduit=achat.getProduit().getPrix();
		a.libelleProduit=achat.getProduit().getLibelle();
		return a;
	}



	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public LocalDate getDateAchat() {
		return dateAchat;
	}



	public void setDateAchat(LocalDate dateAchat) {
		this.dateAchat = dateAchat;
	}



	public int getQuantite() {
		return quantite;
	}



	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}



	public Integer getIdProduit() {
		return idProduit;
	}



	public void setIdProduit(Integer idProduit) {
		this.idProduit = idProduit;
	}



	public double getPrixProduit() {
		return prixProduit;
	}



	public void setPrixProduit(double prixProduit) {
		this.prixProduit = prixProduit;
	}



	public String getLibelleProduit() {
		return libelleProduit;
	}



	public void setLibelleProduit(String libelleProduit) {
		this.libelleProduit = libelleProduit;
	}



	
}
