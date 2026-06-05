package eshop.test;

public class TestDAO {

	/*public static IDAOAchat daoAchat = Singleton.getInstance().getDaoAchat();
	public static IDAOPersonne daoPersonne = Singleton.getInstance().getDaoPersonne();
	public static IDAOProduit daoProduit = Singleton.getInstance().getDaoProduit();

	
	public static void main(String[] args) {
			
		// SAUVEGARDE DES DATA
		
		Fournisseur fournisseur1 = new Fournisseur("Jordan2","Abid",Genre.homme, "AJC INGENIERIE");
		Fournisseur fournisseur2 = new Fournisseur("Emmanuel2","Macron",Genre.homme, "LA FRANCE");
		Fournisseur fournisseur3 = new Fournisseur("F2","Nac",Genre.homme, "Fnac");
		
		//System.out.println("Sauvegarder les fournisseurs");
		fournisseur1=(Fournisseur) daoPersonne.save(fournisseur1);
		fournisseur2=(Fournisseur) daoPersonne.save(fournisseur2);
		fournisseur3=(Fournisseur) daoPersonne.save(fournisseur3);
	
		Produit produit1 = new Produit("Formation SQL",950,fournisseur1);
		Produit produit2 = new Produit("Impots",1250.99,fournisseur2);
		Produit produit3 = new Produit("Manga",7.99,fournisseur3);
		
		//System.out.println("Sauvegarder un produit");
		produit1=daoProduit.save(produit1);
		produit2=daoProduit.save(produit2);
		produit3=daoProduit.save(produit3);
		
		
		Client client1 = new Client("John2","Doe",Genre.nb,LocalDate.parse("1965-01-22"),"161","Avenue de Verdun","Ivry sur Seine","94200");
		Client client2 = new Client("Cecile2","J",Genre.femme,LocalDate.parse("1996-03-25"),"10","Rue de la CDC","Rosny","93110");
		Client client3 = new Client("Antoine2","S",Genre.homme,LocalDate.parse("1995-11-17"),"37","Rue EG","Alfortville","94JSP");
		
		//System.out.println("Sauvegarder les clients");
		client1=(Client) daoPersonne.save(client1);
		client2=(Client) daoPersonne.save(client2);
		client3=(Client) daoPersonne.save(client3);
		
		Achat achat1 = new Achat(LocalDate.parse("2026-01-01"),1,client1,produit1);
		Achat achat2 = new Achat(LocalDate.parse("2026-03-01"),2,client2,produit2);
		Achat achat3 = new Achat(LocalDate.now(),1,client3,produit3);
		Achat achat4 = new Achat(LocalDate.now(),1,client1,produit3);
		Achat achat5 = new Achat(LocalDate.now(),1,client2,produit1);
		
		//System.out.println("Sauvegarder un achat");
		achat1 = daoAchat.save(achat1);
		achat2=daoAchat.save(achat2);
		achat3=daoAchat.save(achat3);
		achat4=daoAchat.save(achat4);
		achat5=daoAchat.save(achat5);

		
		// TESTS DAO PERSONNES
		
		System.out.println("Voir les personnes en fonction de leur id");
		System.out.println(daoPersonne.findById(1));
				
		System.out.println("Voir la liste des personnes");
		System.out.println(daoPersonne.findAll());
			
			System.out.println("Supprimer une personne");
		//ATTENTION 
			//daoPersonne.delete(client1); //ne marche pas, il faut suppr les achats de ce client avant
				
		System.out.println("Supprimer une personne en fonction de son id");
		//ATTENTION 	
			//daoPersonne.deleteById(2);//ne marche pas, il faut suppr les achats de ce client avant

		System.out.println("Afficher la liste des fournisseurs");
		System.out.println(daoPersonne.findAllFournisseur());
		
		System.out.println("Afficher la liste des clients");
		System.out.println(daoPersonne.findAllClient());
		
		System.out.println("Afficher la liste des clients avec leurs achats en fonction de leur id");
		System.out.println(daoPersonne.findByIdWithAchats(6));
				
		
		// TESTS DAO PRODUITS
		
		System.out.println("Afficher la liste des produits en fonction de leur libelle");
		System.out.println(daoProduit.findByLibLike("Manga"));
		
		System.out.println("Afficher la liste des produits en fonction de leur id avec leurs ventes");
		System.out.println(daoProduit.findByIdWithVentes(1));
		
		
		// TESTS DAO ACHATS
				
		System.out.println("Voir les achats en fonction de leur id");
		System.out.println(daoAchat.findById(1));
		
		System.out.println("Voir la liste des achats");
		System.out.println(daoAchat.findAll());
		
		System.out.println("Supprimer un achat");
		daoAchat.delete(achat3);
		
		System.out.println("Supprimer un achat en fonction de son id");
		daoAchat.deleteById(2);

		daoPersonne.delete(client3); 
	}
	*/

}
