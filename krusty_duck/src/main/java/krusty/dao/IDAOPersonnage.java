package krusty.dao;

import java.util.List;

import krusty.model.Client;
import krusty.model.Employe;
import krusty.model.Patron;
import krusty.model.Personnage;

public interface IDAOPersonnage extends IDAO<Personnage,Integer> {

	public List<Client> findAllClient();
	
	public List<Patron> findAllPatron();
	
	public List<Employe> findAllEmploye();
	
	public Client findByIdWithAchats(Integer idClient);
	
}
