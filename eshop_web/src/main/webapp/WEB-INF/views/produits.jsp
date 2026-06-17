<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Gestion des produits</title>
</head>
<body>

<content>
	<table>
		<tr>
			<th>ID</th>
			<th>Libelle</th>
			<th>Prix</th>
			<th>Fournisseur</th>
			<th>Actions</th>
		</tr>
	
		<c:if test="${produits.isEmpty()}"><tr><td colspan="100%" align="center">Aucun Produit</td></tr></c:if>
		
		<c:forEach var="produit" items="${produits}" >
			<tr>
				<td>${produit.id}</td>
				<td>${produit.libelle}</td>
				<td>${produit.prix}€</td>
				<td>${produit.fournisseur.infosSelect}</td>
				<td>
					<a href="produit/${produit.id}" class="btn btn-warning">Modifier</a>
					<a href="produit/delete/${produit.id}" class="btn btn-danger">Supprimer</a>
				</td>
			</tr>
		</c:forEach>
		
	</table>
	
	
	<c:if test="${produit.id==null}">
		<div class="message-form">Formulaire d'ajout Produit</div>
		<c:set var="buttonText" value="Ajouter"></c:set>
		<c:set var="urlForm" value="produit"/>
	</c:if>
	
	<c:if test="${produit.id!=null}">
		<div class="message-form">Formulaire d'update Produit</div>
		<c:set var="buttonText" value="Modifier"></c:set>
		<c:set var="urlForm" value="produit/${produit.id}"/>
	</c:if>
	
	
	
	<form:form action="produit" method="POST" modelAttribute="produit" class="form-clean">
		
		<form:hidden path="id"/>
		
		<form:label path="libelle">Libelle</form:label><form:input required="required" type="text" path="libelle" placeholder="Saisir libelle" />
		<form:errors path="libelle"/>
		
		<form:label path="prix">Prix</form:label><form:input required="required" type="number" path="prix" step="0.01" />
		<form:errors path="prix"/>
		
		<form:select required="required" path="fournisseur.id">
			<form:option value="">Choisir un fournisseur</form:option>
			<form:options items="${fournisseurs}" itemValue="id" itemLabel="infosSelect"/>
		</form:select>
		
		
		<div class="form-actions">
			<input type="submit" class="btn btn-success" value="${buttonText}">
			<input type="reset" class="btn btn-secondary" value="Reset">
			
			<c:if test="${produit.id!=null}">
				<a href="produit" class="btn btn-primary">Annuler</a>
			</c:if>
		</div>
	
	</form:form>
	
	<br><br>
	<a class="btn btn-info" href="home">Retour</a>
</content>
</body>
</html>