<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>Projet Quest</title>
</head>
<body>


<h1>PROJET QUEST</h1>



<form action="home" method="POST">
	<input type="text" name="login" placeholder="Saisir login">
	<input type="password" name="password" placeholder="Saisir password">
	<input type="submit" value="Se connecter">
	
	<c:if test="${param.error==''}">
		<div class="error-form">Identifiants invalides</div>
	</c:if>
</form>


</body>
</html>