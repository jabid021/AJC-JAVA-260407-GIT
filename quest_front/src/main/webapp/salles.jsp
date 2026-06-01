<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js" integrity="sha384-FKyoEForCGlyvwx9Hj09JcYn3nv7wiPVlz7YYwJrWVcXK/BmnVDxM+D2scQbITxI" crossorigin="anonymous"></script>

<link rel="stylesheet" href="style.css">
<title>Gestion des salles</title>
</head>
<body>

<p>${salles}</p>
<content>

	<table>
		<tr>
			<th>ID</th>
			<th>Nom</th>
			<th>Adresse</th>
			<th>Actions</th>
		</tr>
		<tr>
			<td>${salles[0].id}</th>
			<td>${salles[0].nom}</th>
			<td>${salles[0].adresse.numero} ${salles[0].adresse.voie}, ${salles[0].adresse.cp} ${salles[0].adresse.ville}</td>
			<td>
				<a href="salle?id=${salles[0].id}" class="btn btn-warning">Modifier</a>
				<a href="salle?id=${salles[0].id}&delete" class="btn btn-danger">Supprimer</a>
			</td>
		</tr>
	</table>
	
	<div class="message-form">Formulaire Salle</div>
	
	
	<form action="salle" method="POST" class="form-clean">
		
	<input type="hidden" name="id">
	
	<input type="text" name="nom" placeholder="Saisir nom">
	<input type="text" name="adresse.numero" placeholder="Saisir numero">
	<input type="text" name="adresse.voie" placeholder="Saisir voie">
	<input type="text" name="adresse.cp" placeholder="Saisir cp">
	<input type="text" name="adresse.ville" placeholder="Saisir ville">
	
	<div class="form-actions">
		<input type="submit" class="btn btn-success" value="Save">
	</div>
	
	</form>
	
	<br><br>
	<a class="btn btn-info" href="espaceAdmin.jsp">Retour</a>
</content>
</body>
</html>