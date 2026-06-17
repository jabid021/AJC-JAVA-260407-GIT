<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Gestion des clients</title>
</head>
<body>

<content>
	<table>
		<tr>
			<th>ID</th>
			<th>Prenom</th>
			<th>Nom</th>
			<th>Civilite</th>
			<th>Naissance</th>
			<th>Adresse</th>
			<th>Actions</th>
		</tr>
	
		<c:if test="${clients.isEmpty()}"><tr><td colspan="100%" align="center">Aucun Client</td></tr></c:if>
		
		<c:forEach var="client" items="${clients}" >
			<tr>
				<td>${client.id}</td>
				<td>${client.prenom}</td>
				<td>${client.nom}</td>
				<td>${client.civilite}</td>
				<td>${client.dateNaissance}</td>
				<td>${client.adresse.numero} ${client.adresse.voie}, ${client.adresse.cp} ${client.adresse.ville}</td>
				<td>
					<a href="client/${client.id}" class="btn btn-warning">Modifier</a>
					<a href="client/delete/${client.id}" class="btn btn-danger">Supprimer</a>
				</td>
			</tr>
		</c:forEach>
		
	</table>
	
	
	<c:if test="${client.id==null}">
		<div class="message-form">Formulaire d'ajout Client</div>
		<c:set var="buttonText" value="Ajouter"></c:set>
		<c:set var="urlForm" value="client"/>
	</c:if>
	
	<c:if test="${client.id!=null}">
		<div class="message-form">Formulaire d'update Client</div>
		<c:set var="buttonText" value="Modifier"></c:set>
		<c:set var="urlForm" value="client/${client.id}"/>
	</c:if>
	
	
	
	<form:form action="client" method="POST" modelAttribute="client" class="form-clean">
		
		<form:hidden path="id"/>
		
		<form:label path="prenom">Prenom</form:label><form:input required="required" type="text" path="prenom" placeholder="Saisir prenom" />
		<form:label path="nom">Nom</form:label><form:input required="required" type="text" path="nom" placeholder="Saisir nom" />
		<form:label path="civilite">Civilite</form:label>
		
		<form:select required="required" path="civilite">
			<form:option value="">Choisir une civilite</form:option>
			<form:options items="${civilites}"/>
		</form:select>
		
		
		<form:label path="dateNaissance">Date Naissance</form:label><form:input required="required" type="date" path="dateNaissance" />
		<h2>Adresse</h2>
		<form:label path="adresse.numero">Numero</form:label><form:input required="required" type="text" path="adresse.numero" placeholder="Saisir numero"/>
		<form:label path="adresse.voie">Voie</form:label><form:input required="required" type="text" path="adresse.voie" placeholder="Saisir voie"/>
		<form:label path="adresse.cp">CP</form:label><form:input required="required" type="text" path="adresse.cp" placeholder="Saisir cp"/>
		<form:label path="adresse.ville">Ville</form:label><form:input required="required" type="text" path="adresse.ville" placeholder="Saisir ville"/>
		
		
		
		
		<div class="form-actions">
			<input type="submit" class="btn btn-success" value="${buttonText}">
			<input type="reset" class="btn btn-secondary" value="Reset">
			
			<c:if test="${client.id!=null}">
				<a href="client" class="btn btn-primary">Annuler</a>
			</c:if>
		</div>
	
	</form:form>
	
	<br><br>
	<a class="btn btn-info" href="home">Retour</a>
</content>
</body>
</html>