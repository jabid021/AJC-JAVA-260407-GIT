package eshop.test;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;

import eshop.dao.IDAOPersonne;
import eshop.dao.IDAOProduit;
import eshop.model.Client;
import eshop.model.Genre;
import eshop.model.Produit;

public class TestSpringJPA {

	@Autowired
	IDAOProduit daoProduit;
	
	@Autowired
	IDAOPersonne daoPersonne;
	
	public void run() 
	{
		
		for(Produit p : daoProduit.findAll()) 
		{
			System.out.println(p);
		}
		
		
		System.out.println(daoProduit.findByPrixLessThan(20));
		System.out.println(daoProduit.findByPrixBetween(5,1000));
	
		System.out.println(daoProduit.findByLibelleContaining("a")); //libelle like %a%
		System.out.println(daoProduit.findByLibelleLike("_a%")); //libelle like "_a%"
		
		
		//Client client = new Client("prenomfdsdf","nom",Genre.nb,LocalDate.now(),"numero","voie","tpt","cp");
		//daoPersonne.save(client);
		
		for(Client c  : daoPersonne.findAllClient()) 
		{
			System.out.println(c);
		}
	}
}
