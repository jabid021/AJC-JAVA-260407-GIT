<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

 <%@ include file="/WEB-INF/securityAdmin.jsp" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">


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
		
		<c:if test="${salles.isEmpty()}"><tr><td colspan="100%" align="center">Aucune Salle</td></tr></c:if>
		
		<c:forEach var="salle" items="${salles}" >
			<tr>
				<td>${salle.id}</td>
				<td>${salle.nom}</td>
				<td>${salle.adresse.numero} ${salle.adresse.voie}, ${salle.adresse.cp} ${salle.adresse.ville}</td>
				<td>
					<a href="salle/${salle.id}" class="btn btn-warning">Modifier</a>
					
					<c:choose>
						<c:when test="${salle.historique.isEmpty()}"><a href="salle/delete/${salle.id}" class="btn btn-danger">Supprimer</a></c:when>
						<c:otherwise><input type="button" disabled class="btn btn-danger" value="Supprimer"></c:otherwise>
					</c:choose>
				</td>
			</tr>
		</c:forEach>
		
	</table>
	
	
	<c:if test="${salle.id==null}">
		<div class="message-form">Formulaire d'ajout Salle</div>
		<c:set var="buttonText" value="Ajouter"></c:set>
		<c:set var="urlForm" value="salle"/>
	</c:if>
	
	<c:if test="${salle.id!=null}">
		<div class="message-form">Formulaire d'update Salle</div>
		<c:set var="buttonText" value="Modifier"></c:set>
		<c:set var="urlForm" value="salle/${salle.id}"/>
	</c:if>
	
	
	
	<form:form action="${urlForm}" method="POST" class="form-clean" modelAttribute="salle">
		
	<form:hidden path="id"/>
	<form:label path="nom">NOM</form:label>
	<form:input required="required" type="text" path="nom" placeholder="Saisir nom"/>
	<form:input required="required" type="text" path="adresse.numero" placeholder="Saisir numero"/>
	<form:input required="required" type="text" path="adresse.voie" placeholder="Saisir voie"/>
	<form:input required="required" type="text" path="adresse.cp" placeholder="Saisir cp"/>
	<form:input required="required" type="text" path="adresse.ville" placeholder="Saisir ville"/>
	
	<div class="form-actions">
		<input type="submit" class="btn btn-success" value="${buttonText}">
		<input type="reset" class="btn btn-secondary" value="Reset">
		
		<c:if test="${salle.id!=null}">
			<a href="salle" class="btn btn-primary">Annuler</a>
		</c:if>
	</div>
	
	</form:form>
	
	<br><br>
	<a class="btn btn-info" href="home">Retour</a>
</content>
</body>
</html>