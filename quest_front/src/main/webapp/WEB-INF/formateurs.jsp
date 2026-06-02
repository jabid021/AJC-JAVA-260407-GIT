<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<%@ include file="/WEB-INF/includePartout.jsp" %>

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
					<a href="formateur?id=${formateur.id}" class="btn btn-warning">Modifier</a>
					<a href="formateur?id=${formateur.id}&delete" class="btn btn-danger">Supprimer</a>
				</td>
			</tr>
		</c:forEach>
		
	</table>
	
	
	<c:if test="${formateur.id==null}">
		<div class="message-form">Formulaire d'ajout Formateur</div>
		<c:set var="buttonText" value="Ajouter"></c:set>
	</c:if>
	
	<c:if test="${formateur.id!=null}">
		<div class="message-form">Formulaire d'update Formateur</div>
		<c:set var="buttonText" value="Modifier"></c:set>
	</c:if>
														
	<form action="formateur" method="POST" class="form-clean">
		
	<input type="hidden" name="id" value="${formateur.id}">
	<input required="required" type="text" name="login" placeholder="Saisir login" value="${formateur.login}">
	<input required="required" type="password" name="password" placeholder="Saisir password" value="${formateur.password}">
	<input required="required" type="text" name="nom" placeholder="Saisir nom" value="${formateur.nom}">
	<input required="required" type="text" name="prenom" placeholder="Saisir prenom" value="${formateur.prenom}">
	
	<select required="required" name="civilite">
		<option value="">Choisir une civilite</option>
		<c:forEach items="${civilites}" var="civ">
			<option <c:if test="${civ==formateur.civilite}">selected</c:if>>${civ}</option>
		</c:forEach>
	</select>
	<div class="choice-group">
		<label for="admin">Compte admin ?</label>
		<c:choose>
			<c:when test="${formateur.admin}"><input checked="checked" name="admin" type="checkbox"></c:when>
			<c:otherwise><input name="admin" type="checkbox"></c:otherwise>
		</c:choose>
	</div>
	
	<div class="form-actions">
		<input type="submit" class="btn btn-success" value="${buttonText}">
		<input type="reset" class="btn btn-secondary" value="Reset">
		
		<c:if test="${formateur.id!=null}">
			<a href="formateur" class="btn btn-primary">Annuler</a>
		</c:if>
	</div>
	
	</form>
	
	<br><br>
	<a class="btn btn-info" href="home">Retour</a>
</content>
</body>
</html>