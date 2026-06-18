package eshop.dto;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.fasterxml.jackson.annotation.JsonFormat;

import eshop.model.Adresse;
import eshop.model.Client;
import eshop.model.Genre;

public class ClientDTO {

	private Integer id;
	private String nom,prenom;
	private Genre civilite;
	
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate dateNaissance;
	private Adresse adresse;
	private List<AchatDTO> achatsCustom;
	
	
	
	public static ClientDTO convert(Client client) 
	{
		ClientDTO clientDTO = new ClientDTO();
		BeanUtils.copyProperties(client, clientDTO);
		return clientDTO;
	}
	
	public static ClientDTO convertWithAchats(Client client) 
	{
		ClientDTO clientDTO = convert(client);
		
		/*List<AchatDTO> achats = new ArrayList();
		for(Achat a : client.getAchats()) 
		{
			achats.add(AchatDTO.convert(a));
		}
		clientDTO.achatsCustom=achats;
		*/
		clientDTO.achatsCustom=client.getAchats().stream().map(a->AchatDTO.convert(a)).toList();
		return clientDTO;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Genre getCivilite() {
		return civilite;
	}

	public void setCivilite(Genre civilite) {
		this.civilite = civilite;
	}

	public LocalDate getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(LocalDate dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	public List<AchatDTO> getAchatsCustom() {
		return achatsCustom;
	}

	public void setAchatsCustom(List<AchatDTO> achatsCustom) {
		this.achatsCustom = achatsCustom;
	}
	
	
}
