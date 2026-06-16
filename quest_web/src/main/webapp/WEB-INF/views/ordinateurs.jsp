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
	
	
	
	<form:form action="${urlForm}" method="POST" class="form-clean" modelAttribute="ordinateur">
		
		<form:hidden path="numero"/>
		<form:hidden path="version"/>
		
		<form:input required="required" type="text" path="marque" placeholder="Saisir marque" />
		<form:errors path="marque"><span class="error-form">Une error custom</span></form:errors>
		<form:errors class="error-form" path="marque"/>
		
		
		<form:input required="required" type="number" path="ram" placeholder="Saisir ram"/>
		<form:errors cssClass="error-form" path="ram"/>
		
		<form:select path="utilisateur.id">
			<form:option value="">Choisir un utilisateur</form:option>
			<form:options items="${utilisateurs}" itemValue="id" itemLabel="infos"/>
		</form:select>
		
		
		<div class="form-actions">
			<input type="submit" class="btn btn-success" value="${buttonText}">
			<input type="reset" class="btn btn-secondary" value="Reset">
			
			<c:if test="${ordinateur.numero!=null}">
				<a href="ordinateur" class="btn btn-primary">Annuler</a>
			</c:if>
		</div>
	
	</form:form>
	
	<br><br>
	<a class="btn btn-info" href="home">Retour</a>
</content>
</body>
</html>