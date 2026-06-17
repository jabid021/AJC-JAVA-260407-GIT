<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Gestion des fournisseurs</title>
</head>
<body>

<content>
	<table>
		<tr>
			<th>ID</th>
			<th>Prenom</th>
			<th>Nom</th>
			<th>Civilite</th>
			<th>Societe</th>
			<th>Actions</th>
		</tr>
	
		<c:if test="${fournisseurs.isEmpty()}"><tr><td colspan="100%" align="center">Aucun Fournisseur</td></tr></c:if>
		
		<c:forEach var="fournisseur" items="${fournisseurs}" >
			<tr>
				<td>${fournisseur.id}</td>
				<td>${fournisseur.prenom}</td>
				<td>${fournisseur.nom}</td>
				<td>${fournisseur.civilite}</td>
				<td>${fournisseur.societe}</td>
				<td>
					<a href="fournisseur/${fournisseur.id}" class="btn btn-warning">Modifier</a>
					<a href="fournisseur/delete/${fournisseur.id}" class="btn btn-danger">Supprimer</a>
				</td>
			</tr>
		</c:forEach>
		
	</table>
	
	
	<c:if test="${fournisseur.id==null}">
		<div class="message-form">Formulaire d'ajout Fournisseur</div>
		<c:set var="buttonText" value="Ajouter"></c:set>
		<c:set var="urlForm" value="fournisseur"/>
	</c:if>
	
	<c:if test="${fournisseur.id!=null}">
		<div class="message-form">Formulaire d'update Fournisseur</div>
		<c:set var="buttonText" value="Modifier"></c:set>
		<c:set var="urlForm" value="fournisseur/${fournisseur.id}"/>
	</c:if>
	
	
	
	<form:form action="fournisseur" method="POST" modelAttribute="fournisseur" class="form-clean">
		
		<form:hidden path="id"/>
		
		<form:label path="prenom">Prenom</form:label><form:input required="required" type="text" path="prenom" placeholder="Saisir prenom" />
		<form:label path="nom">Nom</form:label><form:input required="required" type="text" path="nom" placeholder="Saisir nom" />
		<form:label path="civilite">Civilite</form:label>
		
		<form:select required="required" path="civilite">
			<form:option value="">Choisir une civilite</form:option>
			<form:options items="${civilites}"/>
		</form:select>
		
		
		<form:label path="societe">Societe</form:label><form:input required="required" type="text" path="societe" placeholder="Saisir societe" />
		
		
		
		
		<div class="form-actions">
			<input type="submit" class="btn btn-success" value="${buttonText}">
			<input type="reset" class="btn btn-secondary" value="Reset">
			
			<c:if test="${fournisseur.id!=null}">
				<a href="fournisseur" class="btn btn-primary">Annuler</a>
			</c:if>
		</div>
	
	</form:form>
	
	<br><br>
	<a class="btn btn-info" href="home">Retour</a>
</content>
</body>
</html>