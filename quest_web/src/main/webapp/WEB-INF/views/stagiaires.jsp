<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

 <%@ include file="/WEB-INF/securityAdmin.jsp" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">


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
					<a href="stagiaire/${stagiaire.id}" class="btn btn-warning">Modifier</a>
					<a href="stagiaire/delete/${stagiaire.id}" class="btn btn-danger">Supprimer</a>
				</td>
			</tr>
		</c:forEach>
		
	</table>
	
	
	<c:if test="${stagiaire.id==null}">
		<div class="message-form">Formulaire d'ajout Stagiaire</div>
		<c:set var="buttonText" value="Ajouter"></c:set>
		<c:set var="urlForm" value="stagiaire"/>
	</c:if>
	
	<c:if test="${stagiaire.id!=null}">
		<div class="message-form">Formulaire d'update Stagiaire</div>
		<c:set var="buttonText" value="Modifier"></c:set>
		<c:set var="urlForm" value="stagiaire/${stagiaire.id}"/>
	</c:if>
														
	<form:form action="${urlForm}" method="POST" class="form-clean" modelAttribute="stagiaire">
		
	<form:hidden path="id"/>
	
	<form:input required="required" type="text" path="login" placeholder="Saisir login" />
	<form:password required="required" path="password" placeholder="Saisir password"/>
	<form:input required="required" type="text" path="nom" placeholder="Saisir nom"/>
	<form:input required="required" type="text" path="prenom" placeholder="Saisir prenom" />
	<!--<c:forEach items="${civilites}" var="civ">
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
			</c:forEach>-->
			
	<div class="choice-group">
			<form:radiobuttons required="required" items="${civilites}"  path="civilite"/>
	</div>
	  
	  
	<form:input required="required" type="email" path="email" placeholder="Saisir email"/>
	<form:input required="required" type="text"  path="adresse.numero" placeholder="Saisir numero"/>
	<form:input required="required" type="text"  path="adresse.voie" placeholder="Saisir voie"/>
	<form:input required="required" type="text"  path="adresse.cp" placeholder="Saisir cp"/>
	<form:input required="required" type="text"  path="adresse.ville" placeholder="Saisir ville"/>
	
	
	<form:select required="required" path="filiere.id">
		<form:option value="">Choisir une filiere</form:option>*
		<form:options items="${filieres}" itemValue="id"  itemLabel="infosFiliere" />
	</form:select>

		<!--<select required="required" name="filiere.id">
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
		-->	
	
	
	<div class="form-actions">
		<input type="submit" class="btn btn-success" value="${buttonText}">
		<input type="reset" class="btn btn-secondary" value="Reset">
		
		<c:if test="${stagiaire.id!=null}">
			<a href="stagiaire" class="btn btn-primary">Annuler</a>
		</c:if>
	</div>
	
	</form:form>
	
	<br><br>
	<a class="btn btn-info" href="home">Retour</a>
</content>
</body>
</html>