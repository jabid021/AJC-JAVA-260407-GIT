<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@ include file="/WEB-INF/includePartout.jsp" %>
<title>Gestion des matieres</title>
</head>
<body>

<content>
	<table>
		<tr>
			<th>ID</th>
			<th>Libelle</th>
			<th>Actions</th>
		</tr>
	
		<c:if test="${matieres.isEmpty()}"><tr><td colspan="100%" align="center">Aucune Matiere</td></tr></c:if>
		
		<c:forEach var="matiere" items="${matieres}" >
			<tr>
				<td>${matiere.id}</td>
				<td>${matiere.libelle}</td><td>
					<a href="matiere?id=${matiere.id}" class="btn btn-warning">Modifier</a>
					<a href="matiere?id=${matiere.id}&delete" class="btn btn-danger">Supprimer</a>
				</td>
			</tr>
		</c:forEach>
		
	</table>
	
	
	<c:if test="${matiere.id==null}">
		<div class="message-form">Formulaire d'ajout Matiere</div>
		<c:set var="buttonText" value="Ajouter"></c:set>
	</c:if>
	
	<c:if test="${matiere.id!=null}">
		<div class="message-form">Formulaire d'update Matiere</div>
		<c:set var="buttonText" value="Modifier"></c:set>
	</c:if>
	
	
	
	<form action="matiere" method="POST" class="form-clean">
		
		<input type="hidden" name="id" value="${matiere.id}">
		
		<input required="required" type="text" name="libelle" placeholder="Saisir libelle" value="${matiere.libelle}">
		
		<div class="form-actions">
			<input type="submit" class="btn btn-success" value="${buttonText}">
			<input type="reset" class="btn btn-secondary" value="Reset">
			
			<c:if test="${matiere.id!=null}">
				<a href="matiere" class="btn btn-primary">Annuler</a>
			</c:if>
		</div>
	
	</form>
	
	<br><br>
	<a class="btn btn-info" href="home">Retour</a>
</content>
</body>
</html>