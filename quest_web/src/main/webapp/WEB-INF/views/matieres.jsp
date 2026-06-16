<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
 
 <%@ include file="/WEB-INF/securityAdmin.jsp" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Gestion des matieres</title>
<script
  src="https://code.jquery.com/jquery-4.0.0.min.js"
  integrity="sha256-OaVG6prZf4v69dPg6PhVattBXkcOWQB62pdZ3ORyrao="
  crossorigin="anonymous"></script>
  
</head>
<body>

<content>
<input type="text" id="filterLib" placeholder="Filtrer par libelle">
	<table>
		<tr>
			<th>ID</th>
			<th>Libelle</th>
			<th>Actions</th>
		</tr>
	
		<c:if test="${matieres.isEmpty()}"><tr><td colspan="100%" align="center">Aucune Matiere</td></tr></c:if>
		
		<tbody id="contentTableau">
			<c:forEach var="matiere" items="${matieres}" >
				<tr>
					<td>${matiere.id}</td>
					<td>${matiere.libelle}</td><td>
						<a href="matiere/${matiere.id}" class="btn btn-warning">Modifier</a>
						<a href="matiere/delete/${matiere.id}" class="btn btn-danger">Supprimer</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	
	<c:if test="${matiere.id==null}">
		<div class="message-form">Formulaire d'ajout Matiere</div>
		<c:set var="buttonText" value="Ajouter"></c:set>
		<c:set var="urlForm" value="matiere"/>
	</c:if>
	
	<c:if test="${matiere.id!=null}">
		<div class="message-form">Formulaire d'update Matiere</div>
		<c:set var="buttonText" value="Modifier"></c:set>
		<c:set var="urlForm" value="matiere/${matiere.id}"/>
	</c:if>
	
	<form:form action="${urlForm}" method="POST" class="form-clean" modelAttribute="matiere" >
		
		<!--  
		<input type="hidden" name="id" value="${matiere.id}">
		<input required="required" type="text" name="libelle" placeholder="Saisir libelle" value="${matiere.libelle}">
		
		
		-->
		<form:hidden path="id"/>
		<form:input required="required" type="text" path="libelle" placeholder="Saisir libelle"/>
		
		<div class="form-actions">
			<input type="submit" class="btn btn-success" value="${buttonText}">
			<input type="reset" class="btn btn-secondary" value="Reset">
			
			<c:if test="${matiere.id!=null}">
				<a href="matiere" class="btn btn-primary">Annuler</a>
			</c:if>
		</div>
	
	</form:form>
	
	

	<br><br>
	<a class="btn btn-info" href="home">Retour</a>
</content>
</body>
</html>


<script>


filterLib.oninput = function()
{
	let contentRecherche = filterLib.value;
	$.ajax("matiere/recherche", {
		type : "GET",
		data : 
		{
			recherche : contentRecherche
		},
	    success: function (resp) {
	    	contentTableau.innerHTML=resp;
	    }
	  });
};


</script>