package eshop.test;

public class TestFind {

	/*public static void main(String[] args) {
		
		List<Fournisseur> fournisseurs = Singleton.getInstance().getDaoPersonne().findAllFournisseur();
		System.out.println("Voici la listes des fournisseurs : ");
		for(Fournisseur f : fournisseurs) {System.out.println(f);}
		
		System.out.println("\n----------------");
		
		
		
		List<Client> clients = Singleton.getInstance().getDaoPersonne().findAllClient();
		System.out.println("Voici la listes des clients : ");
		for(Client c : clients) {System.out.println(c);}
		
		System.out.println("\n----------------");
		
		
		
		
		Client client2 = Singleton.getInstance().getDaoPersonne().findByIdWithAchats(2);
		System.out.println("Informations du client 2 : "+client2);
		if(client2.getAchats().isEmpty()) {System.out.println("Ce client n'a pas encore fait d'achat");}
		else 
		{
			System.out.println("Liste de ses achats : ");
			for(Achat a : client2.getAchats()) {System.out.println(a);}
		}
		
		
		
		
		System.out.println("\n----------------");
		
		
		
		Fournisseur fournisseur1 = Singleton.getInstance().getDaoPersonne().findByIdWithStock(1);
		System.out.println("Informations du fournisseur 1 : "+fournisseur1);
		if(fournisseur1.getStock().isEmpty()) {System.out.println("Ce fournisseur n'a pas de produit dans la bdd");}
		else 
		{
			System.out.println("Liste de ses produits : ");
			for(Produit p : fournisseur1.getStock()) {System.out.println(p);}
		}
		
	
		
		System.out.println("\n----------------");
		
		
		
		Produit produit1 = Singleton.getInstance().getDaoProduit().findByIdWithVentes(1);
		System.out.println("Informations du produit 1 : "+produit1);
		if(produit1.getVentes().isEmpty()) {System.out.println("Ce produit n'a jamais été vendu");}
		else 
		{
			System.out.println("Liste de ses ventes : ");
			for(Achat a : produit1.getVentes()) {System.out.println(a);}
		}
		
	
		

		Produit produit2 = Singleton.getInstance().getDaoProduit().findByIdWithVentes(2);
		System.out.println("Informations du produit 2 : "+produit2);
		if(produit2.getVentes().isEmpty()) {System.out.println("Ce produit n'a jamais été vendu");}
		else 
		{
			System.out.println("Liste de ses ventes : ");
			for(Achat a : produit2.getVentes()) {System.out.println(a);}
		}
		
		
		System.out.println("\n----------------");
		
		
		
		
		
		String recherche = "%Ang%";
		

		List<Produit> produits = Singleton.getInstance().getDaoProduit().findByLibLike(recherche);
		System.out.println("Voici la listes des produit like "+recherche);
		for(Produit p : produits) {System.out.println(p);}
		
		System.out.println("\n----------------");
		
		
		
	}*/

}
