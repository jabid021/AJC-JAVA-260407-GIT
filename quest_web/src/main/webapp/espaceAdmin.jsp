<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%@ include file="/WEB-INF/securityAdmin.jsp" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Gestion Admin</title>
</head>
<body>

<h1>Bienvenue ${connected.login} sur votre page de gestion admin</h1>


<ul>
	<li><a href="filiere">Gestion Filieres</a></li>
	<li><a href="stagiaire">Gestion Stagiaires</a></li>
	<li><a href="formateur">Gestion Formateurs</a></li>
	<li><a href="matiere">Gestion Matieres</a></li>
	<li><a href="ordinateur">Gestion Ordinateurs</a></li>
	<li><a href="salle">Gestion Salles</a></li>
</ul>

</body>
</html>