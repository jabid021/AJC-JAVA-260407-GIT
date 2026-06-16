<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
 <%@ include file="/WEB-INF/securityAdmin.jsp" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Gestion des filieres</title>
</head>
<body>

<content>
	<table>
		<tr>
			<th>ID</th>
			<th>Libelle</th>
			<th>Debut</th>
			<th>Fin</th>
			<th>Salle</th>
			<th>Actions</th>
		</tr>
	
		<c:if test="${filieres.isEmpty()}"><tr><td colspan="100%" align="center">Aucune Filiere</td></tr></c:if>
		
		<c:forEach var="filiere" items="${filieres}" >
			<tr>
				<td>${filiere.id}</td>
				<td>${filiere.libelle}</td>
				<td>${filiere.debut}</td>
				<td>${filiere.fin}</td>
				<td>
				<c:choose>
					<c:when test="${filiere.salle==null}">DISTANCE</c:when>
					<c:otherwise>${filiere.salle.id} - ${filiere.salle.nom}</c:otherwise>
				</c:choose>
				</td>
				<td>
					<a href="filiere/${filiere.id}" class="btn btn-warning">Modifier</a>
					<a href="filiere/delete/${filiere.id}" class="btn btn-danger">Supprimer</a>
				</td>
			</tr>
		</c:forEach>
		
	</table>
	
	
	<c:if test="${filiere.id==null}">
		<div class="message-form">Formulaire d'ajout Filiere</div>
		<c:set var="buttonText" value="Ajouter"></c:set>
		<c:set var="urlForm" value="filiere"/>
	</c:if>
	
	<c:if test="${filiere.id!=null}">
		<div class="message-form">Formulaire d'update Filiere</div>
		<c:set var="buttonText" value="Modifier"></c:set>
		<c:set var="urlForm" value="filiere/${filiere.id}"/>
	</c:if>
	
	
	
	<form:form action="filiere" method="POST" modelAttribute="filiere" class="form-clean">
		
		<form:hidden path="id"/>
		
		<form:label path="libelle">Libelle</form:label><form:input required="required" type="text" path="libelle" placeholder="Saisir libelle" />
		<form:label path="debut">Date Debut</form:label><form:input required="required" type="date" path="debut" />
		<form:label path="fin">Date Fin</form:label><form:input required="required" type="date" path="fin" />
		<form:label path="salle.id">Salle</form:label>
		
		<form:select path="salle.id">
			<form:option value="">Choisir une salle</form:option>
			<form:options items="${salles}" itemValue="id" itemLabel="nom"/>
		</form:select>
		
		
		<div class="form-actions">
			<input type="submit" class="btn btn-success" value="${buttonText}">
			<input type="reset" class="btn btn-secondary" value="Reset">
			
			<c:if test="${filiere.id!=null}">
				<a href="filiere" class="btn btn-primary">Annuler</a>
			</c:if>
		</div>
	
	</form:form>
	
	<br><br>
	<a class="btn btn-info" href="home">Retour</a>
</content>
</body>
</html>