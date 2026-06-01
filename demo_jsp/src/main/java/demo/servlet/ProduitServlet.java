package demo.servlet;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import krusty.dao.DAOProduit;
import krusty.model.Produit;

@WebServlet("/produitsV1")
public class ProduitServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DAOProduit daoProduit = new DAOProduit();
		List<Produit> produits = daoProduit.findAll();
		response.getWriter().println("<table border><tr><th>ID</th><th>Nom</th><th>Prix</th><th>Stock</th><th>Restaurant</th></tr>");
		for(Produit p : produits) 
		{
			response.getWriter().println("<tr><td>"+p.getId()+"</td><td>"+p.getNom()+"</td><td>"+p.getPrix()+"€</td><td>"+p.getStock()+"</td><td>"+p.getRestaurant().getNom()+"</td></tr>");
		}
		response.getWriter().println("</table>");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
