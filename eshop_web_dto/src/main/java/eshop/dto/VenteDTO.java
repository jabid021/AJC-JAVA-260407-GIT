package eshop.dto;

import java.time.LocalDate;

import org.springframework.beans.BeanUtils;

import com.fasterxml.jackson.annotation.JsonFormat;

import eshop.model.Achat;

public class VenteDTO {

	private Integer id;
	@JsonFormat(pattern="yyyy-MM-dd")
	private LocalDate dateAchat;
	private int quantite;
	private String infos;
	
	
	
	public static VenteDTO convert(Achat achat) 
	{
		VenteDTO v = new VenteDTO();
		BeanUtils.copyProperties(achat,v);
		v.infos=achat.getClient().getPrenom()+" "+achat.getClient().getNom();
		return v;
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



	public String getInfos() {
		return infos;
	}



	public void setInfos(String infos) {
		this.infos = infos;
	}
	
	
}
