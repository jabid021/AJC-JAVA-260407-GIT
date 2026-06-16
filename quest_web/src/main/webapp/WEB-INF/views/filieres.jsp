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
	
	
	
	<form action="filiere" method="POST" class="form-clean">
		
		<input type="hidden" name="id" value="${filiere.id}">
		
		<label for="libelle">Libelle</label><input id="libelle" required="required" type="text" name="libelle" placeholder="Saisir libelle" value="${filiere.libelle}">
		<label for="debut">Date Debut</label><input id="debut" required="required" type="date" name="debut" value="${filiere.debut}">
		<label for="fin">Date Fin</label><input id="fin" required="required" type="date" name="fin" value="${filiere.fin}">
		<label for="salle.id">Salle</label>
		<select id="salle.id" name="salle.id">
			<option value="">Choisir une salle</option>
			<c:forEach var="salle" items="${salles}" >
				<c:choose>
					<c:when test="${salle.id==filiere.salle.id}">
						<option selected value="${salle.id}">${salle.id} - ${salle.nom}</option>
					</c:when>
					<c:otherwise>
						<option value="${salle.id}">${salle.id} - ${salle.nom}</option>
					</c:otherwise>
				</c:choose>
			</c:forEach>
		</select>
		
		
		<div class="form-actions">
			<input type="submit" class="btn btn-success" value="${buttonText}">
			<input type="reset" class="btn btn-secondary" value="Reset">
			
			<c:if test="${filiere.id!=null}">
				<a href="filiere" class="btn btn-primary">Annuler</a>
			</c:if>
		</div>
	
	</form>
	
	<br><br>
	<a class="btn btn-info" href="home">Retour</a>
</content>
</body>
</html>