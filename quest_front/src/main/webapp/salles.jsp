<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="jakarta.tags.core"%>   
    
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
<!--  
<p>Liste des nombres de 1 à 10<p>
<ul>
	<c:forEach begin="1" end="10" step="1" var="i">
		<li>${i}</li>
	</c:forEach>
</ul>
-->
<content>
	<table>
		<tr>
			<th>ID</th>
			<th>Nom</th>
			<th>Adresse</th>
			<th>Actions</th>
		</tr>
		
		<c:forEach var="salle" items="${salles}" >
			<tr>
				<td>${salle.id}</th>
				<td>${salle.nom}</th>
				<td>${salle.adresse.numero} ${salle.adresse.voie}, ${salle.adresse.cp} ${salle.adresse.ville}</td>
				<td>
					<a href="salle?id=${salle.id}" class="btn btn-warning">Modifier</a>
					<a href="salle?id=${salle.id}&delete" class="btn btn-danger">Supprimer</a>
				</td>
			</tr>
		</c:forEach>
		
	</table>
	
	
	<c:if test="${salle.id==null}">
		<div class="message-form">Formulaire d'ajout Salle</div>
		<c:set var="buttonText" value="Ajouter"></c:set>
	</c:if>
	
	<c:if test="${salle.id!=null}">
		<div class="message-form">Formulaire d'update Salle</div>
		<c:set var="buttonText" value="Modifier"></c:set>
	</c:if>
	
	
	
	<form action="salle" method="POST" class="form-clean">
		
	<input type="hidden" name="id" value="${salle.id}">
	
	<input required="required" type="text" name="nom" placeholder="Saisir nom" value="${salle.nom}">
	<input required="required" type="text" name="adresse.numero" placeholder="Saisir numero" value="${salle.adresse.numero}">
	<input required="required" type="text" name="adresse.voie" placeholder="Saisir voie" value="${salle.adresse.voie}">
	<input required="required" type="text" name="adresse.cp" placeholder="Saisir cp" value="${salle.adresse.cp}">
	<input required="required" type="text" name="adresse.ville" placeholder="Saisir ville" value="${salle.adresse.ville}">
	
	<div class="form-actions">
		<input type="submit" class="btn btn-success" value="${buttonText}">
		<input type="reset" class="btn btn-secondary" value="Reset">
		
		<c:if test="${salle.id!=null}">
			<a href="salle" class="btn btn-primary">Annuler</a>
		</c:if>
	</div>
	
	</form>
	
	<br><br>
	<a class="btn btn-info" href="espaceAdmin.jsp">Retour</a>
</content>
</body>
</html>