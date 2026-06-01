package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import krusty.dao.DAOProduit;
import krusty.model.Produit;

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
		
	}

}
