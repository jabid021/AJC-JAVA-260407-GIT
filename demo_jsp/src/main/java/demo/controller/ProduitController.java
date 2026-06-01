package demo.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import krusty.dao.DAOProduit;
import krusty.model.Produit;
import krusty.model.Restaurant;

import java.io.IOException;
import java.util.List;


@WebServlet("/produit")
public class ProduitController extends HttpServlet {
       
   
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DAOProduit daoProduit = new DAOProduit();
		List<Produit> produits = daoProduit.findAll();
		
		//On veut attacher des données vers la jsp
		request.setAttribute("listeDesProduits",produits);
		//Envoyer la liste de produits vers produits.jsp
		this.getServletContext().getRequestDispatcher("/produits.jsp").forward(request, response); 
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DAOProduit daoProduit = new DAOProduit();
		String nom = request.getParameter("nom");
		double prix = Double.parseDouble(request.getParameter("prix"));
		int stock = Integer.parseInt(request.getParameter("stock"));
		Integer idRestaurant = Integer.parseInt(request.getParameter("restaurant.id"));
		
		Restaurant restaurant = new Restaurant();
		restaurant.setId(idRestaurant);
		
		Produit produit = new Produit(nom,prix,stock,restaurant);
		
		System.out.println("produit form : "+produit);
		daoProduit.save(produit);
		
		response.sendRedirect("produit");
		
	
	}

}
