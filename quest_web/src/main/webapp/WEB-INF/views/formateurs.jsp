<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<%@ include file="/WEB-INF/securityAdmin.jsp" %>


    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">


<title>Gestion des formateurs</title>
</head>
<body>

<content>
	<table>
		<tr>
			<th>ID</th>
			<th>Login</th>
			<th>Password</th>
			<th>Nom</th>
			<th>Prenom</th>
			<th>Civilite</th>
			<th>Admin</th>
			<th>Actions</th>
		</tr>
		
		<c:if test="${formateurs.isEmpty()}"><tr><td colspan="100%" align="center">Aucun Formateur</td></tr></c:if>
		
		<c:forEach var="formateur" items="${formateurs}" >
			<tr>
				<td>${formateur.id}</td>
				<td>${formateur.login}</td>
				<td>${formateur.password}</td>
				<td>${formateur.nom}</td>
				<td>${formateur.prenom}</td>
				<td>${formateur.civilite}</td>
				<td>Est admin : ${formateur.admin}</td>
				<td>
					<a href="formateur/${formateur.id}" class="btn btn-warning">Modifier</a>
					<a href="formateur/delete/${formateur.id}" class="btn btn-danger">Supprimer</a>
				</td>
			</tr>
		</c:forEach>
	</table>
	
	
	<c:if test="${formateur.id==null}">
		<div class="message-form">Formulaire d'ajout Formateur</div>
		<c:set var="buttonText" value="Ajouter"></c:set>
		<c:set var="urlForm" value="formateur"/>
	</c:if>
	
	<c:if test="${formateur.id!=null}">
		<div class="message-form">Formulaire d'update Formateur</div>
		<c:set var="buttonText" value="Modifier"></c:set>
		<c:set var="urlForm" value="formateur/${formateur.id}"/>
	</c:if>
														
	<form:form action="${urlForm}" method="POST" modelAttribute="formateur" class="form-clean">
		
	<form:hidden path="id" />
	<form:input required="required" type="text" path="login" placeholder="Saisir login" />
	<form:input required="required" path="password" placeholder="Saisir password" />
	<form:input required="required" type="text" path="nom" placeholder="Saisir nom" />
	<form:input required="required" type="text" path="prenom" placeholder="Saisir prenom" />
	
	<form:select required="required" path="civilite">
		<form:option value="">Choisir une civilite</form:option>
		<form:options items="${civilites}"/>
	</form:select>
	
	<div class="choice-group">
		<label for="admin">Compte admin ?</label>
		<form:checkbox path="admin"/>
	</div>
	
	<div class="form-actions">
		<input type="submit" class="btn btn-success" value="${buttonText}">
		<input type="reset" class="btn btn-secondary" value="Reset">
		
		<c:if test="${formateur.id!=null}">
			<a href="formateur" class="btn btn-primary">Annuler</a>
		</c:if>
	</div>
	
	</form:form>
	
	<br><br>
	<a class="btn btn-info" href="home">Retour</a>
</content>
</body>
</html>