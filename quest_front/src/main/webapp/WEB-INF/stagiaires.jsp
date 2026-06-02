<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<%@ include file="/WEB-INF/includePartout.jsp" %>

<title>Gestion des stagiaires</title>
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
			<th>Email</th>
			<th>Adresse</th>
			<th>Filiere</th>
			<th>Actions</th>
		</tr>
		
		<c:if test="${stagiaires.isEmpty()}"><tr><td colspan="100%" align="center">Aucun Stagiaire</td></tr></c:if>
		
		<c:forEach var="stagiaire" items="${stagiaires}" >
			<tr>
				<td>${stagiaire.id}</td>
				<td>${stagiaire.login}</td>
				<td>${stagiaire.password}</td>
				<td>${stagiaire.nom}</td>
				<td>${stagiaire.prenom}</td>
				<td>${stagiaire.civilite}</td>
				<td>${stagiaire.email}</td>
				<td>${stagiaire.adresse.numero} ${stagiaire.adresse.voie}, ${stagiaire.adresse.cp} ${stagiaire.adresse.ville}</td>
				<td>${stagiaire.filiere.infosFiliere}</td>
				<td>
					<a href="stagiaire?id=${stagiaire.id}" class="btn btn-warning">Modifier</a>
					<a href="stagiaire?id=${stagiaire.id}&delete" class="btn btn-danger">Supprimer</a>
				</td>
			</tr>
		</c:forEach>
		
	</table>
	
	
	<c:if test="${stagiaire.id==null}">
		<div class="message-form">Formulaire d'ajout Stagiaire</div>
		<c:set var="buttonText" value="Ajouter"></c:set>
	</c:if>
	
	<c:if test="${stagiaire.id!=null}">
		<div class="message-form">Formulaire d'update Stagiaire</div>
		<c:set var="buttonText" value="Modifier"></c:set>
	</c:if>
														
	<form action="stagiaire" method="POST" class="form-clean">
		
	<input type="hidden" name="id" value="${stagiaire.id}">
	<input required="required" type="text" name="login" placeholder="Saisir login" value="${stagiaire.login}">
	<input required="required" type="password" name="password" placeholder="Saisir password" value="${stagiaire.password}">
	<input required="required" type="text" name="nom" placeholder="Saisir nom" value="${stagiaire.nom}">
	<input required="required" type="text" name="prenom" placeholder="Saisir prenom" value="${stagiaire.prenom}">
	<div class="choice-group">
		
		<div class="choice-group">
			<c:forEach items="${civilites}" var="civ">
				<div class="choice-item">
					<c:choose>
						<c:when test="${stagiaire.civilite==civ}">
							<input required="required" type="radio" checked id="civilite-${civ}" name="civilite" value="${civ}">
							
						</c:when>
						<c:otherwise>
							<input required="required" type="radio" id="civilite-${civ}" name="civilite" value="${civ}">
							
						</c:otherwise>
					</c:choose>
					<label for="civilite-${civ}">${civ}</label>
				</div>
			</c:forEach>
		</div>
	</div>
	<input required="required" type="email" name="email" placeholder="Saisir email" value="${stagiaire.email}">
	<input required="required" type="text" name="adresse.numero" placeholder="Saisir numero" value="${stagiaire.adresse.numero}">
	<input required="required" type="text" name="adresse.voie" placeholder="Saisir voie" value="${stagiaire.adresse.voie}">
	<input required="required" type="text" name="adresse.cp" placeholder="Saisir cp" value="${stagiaire.adresse.cp}">
	<input required="required" type="text" name="adresse.ville" placeholder="Saisir ville" value="${stagiaire.adresse.ville}">
	
		<select required="required" name="filiere.id">
			<option value="">Choisir une filiere</option>
			<c:forEach var="filiere" items="${filieres}" >
				<c:choose>
					<c:when test="${filiere.id==stagiaire.filiere.id}">
						<option selected value="${filiere.id}">${filiere.infosFiliere}</option>
					</c:when>
					<c:otherwise>
						<option value="${filiere.id}">${filiere.infosFiliere}</option>
					</c:otherwise>
				</c:choose>
			</c:forEach>
		</select>
			
	
	
	<div class="form-actions">
		<input type="submit" class="btn btn-success" value="${buttonText}">
		<input type="reset" class="btn btn-secondary" value="Reset">
		
		<c:if test="${stagiaire.id!=null}">
			<a href="stagiaire" class="btn btn-primary">Annuler</a>
		</c:if>
	</div>
	
	</form>
	
	<br><br>
	<a class="btn btn-info" href="home">Retour</a>
</content>
</body>
</html>