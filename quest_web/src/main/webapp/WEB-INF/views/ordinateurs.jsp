<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
 <%@ include file="/WEB-INF/securityAdmin.jsp" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>Gestion des ordinateurs</title>
</head>
<body>

<content>
	<table>
		<tr>
			<th>Numero</th>
			<th>Marque</th>
			<th>Ram</th>
			<th>Utilisateur</th>
			<th>Actions</th>
		</tr>
	
		<c:if test="${ordinateurs.isEmpty()}"><tr><td colspan="100%" align="center">Aucun Ordinateur</td></tr></c:if>
		
		<c:forEach var="ordinateur" items="${ordinateurs}" >
			<tr>
				<td>${ordinateur.numero}</td>
				<td>${ordinateur.marque}</td>
				<td>${ordinateur.ram}Go</td>
				<td>
				<c:choose>
					<c:when test="${ordinateur.utilisateur==null}">Pas d'utilisateur</c:when>
					<c:otherwise>${ordinateur.utilisateur.id} - ${ordinateur.utilisateur.prenom} ${ordinateur.utilisateur.nom}</c:otherwise>
				</c:choose>
				</td>
				<td>
					<a href="ordinateur/${ordinateur.numero}" class="btn btn-warning">Modifier</a>
					<a href="ordinateur/delete/${ordinateur.numero}" class="btn btn-danger">Supprimer</a>
				</td>
			</tr>
		</c:forEach>
		
	</table>
	
	
	<c:if test="${ordinateur.numero==null}">
		<div class="message-form">Formulaire d'ajout Ordinateur</div>
		<c:set var="buttonText" value="Ajouter"></c:set>
		<c:set var="urlForm" value="ordinateur"/>
	</c:if>
	
	<c:if test="${ordinateur.numero!=null}">
		<div class="message-form">Formulaire d'update Ordinateur</div>
		<c:set var="buttonText" value="Modifier"></c:set>
		<c:set var="urlForm" value="ordinateur/${ordinateur.numero}"/>
	</c:if>
	
	
	
	<form action="${urlForm}" method="POST" class="form-clean">
		
		<input type="hidden" name="numero" value="${ordinateur.numero}">
		<input type="hidden" name="version" value="${ordinateur.version}">
		
		<input required="required" type="text" name="marque" placeholder="Saisir marque" value="${ordinateur.marque}">
		<input required="required" type="number" name="ram" placeholder="Saisir ram" value="${ordinateur.ram}" min="0" max="64">
		
		<select name="utilisateur.id">
			<option value="">Choisir un utilisateur</option>
			<c:forEach var="stagiaire" items="${utilisateurs}" >
				<c:choose>
					<c:when test="${stagiaire.id==ordinateur.utilisateur.id}">
						<option selected value="${stagiaire.id}">${stagiaire.id} - ${stagiaire.prenom} ${stagiaire.nom}</option>
					</c:when>
					<c:otherwise>
						<option value="${stagiaire.id}">${stagiaire.id} - ${stagiaire.prenom} ${stagiaire.nom}</option>
					</c:otherwise>
				</c:choose>
			</c:forEach>
		</select>
		
		
		<div class="form-actions">
			<input type="submit" class="btn btn-success" value="${buttonText}">
			<input type="reset" class="btn btn-secondary" value="Reset">
			
			<c:if test="${ordinateur.numero!=null}">
				<a href="ordinateur" class="btn btn-primary">Annuler</a>
			</c:if>
		</div>
	
	</form>
	
	<br><br>
	<a class="btn btn-info" href="home">Retour</a>
</content>
</body>
</html>