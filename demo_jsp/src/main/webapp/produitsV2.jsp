<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="krusty.dao.DAOProduit" %>
<%@ page import="krusty.model.*" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Liste des produits</title>
</head>
<body>



	<table border>
		<tr><th>ID</th><th>Nom</th><th>Prix</th><th>Stock</th><th>Restaurant</th></tr>
		<% 
		
		out.println("Param login ? "+request.getParameter("login"));
		DAOProduit daoProduit = new DAOProduit();
		List<Produit> produits = daoProduit.findAll();
		
		for(Produit p : produits)
		{
			out.println("<tr><td>"+p.getId()+"</td><td>"+p.getNom()+"</td><td>"+p.getPrix()+"€</td><td>"+p.getStock()+"</td><td>"+p.getRestaurant().getNom()+"</td></tr>");
		}
		
		%> 
		
	

</table>
</body>
</html>