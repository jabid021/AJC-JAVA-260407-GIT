<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Liste des produits</title>
</head>
<body>

<h1>Gestion des produits</h1>


<p>${listeDesProduits}</p>
<table border>
		<tr>
			<th>ID</th><th>Nom</th><th>Prix</th><th>Stock</th><th>Restaurant</th>
		</tr>
		<tr>
			<td>${listeDesProduits[0].id}</td><td>${listeDesProduits[0].nom}</td><td>${listeDesProduits[0].prix}</td><td>${listeDesProduits[0].stock}</td><td>${listeDesProduits[0].restaurant.nom}</td>
		
		</tr>
		<!-- Comment afficher des données provenants du controlleur -->
</table>



<form action="produit" method="POST">

	<input type="text" name="nom" placeholder="Saisir le nom du produit">
	<input type="number" step="0.01" name="prix" placeholder="Saisir le prix">
	<input type="number" name="stock" placeholder="Saisir le stock">
	<select name="restaurant.id">
		<option value="5">5-Crousty Krab</option>
	</select>
	<input type="submit" value="Ajouter">
</form>
</body>
</html>