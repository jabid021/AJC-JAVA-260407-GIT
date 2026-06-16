<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Bonjour ${login} vous êtes connecté en tant que ${role}</h1>


<ul>

	<li><a href="client">Gestion des clients</a></li>
	<li><a href="fournisseur">Gestion des fournisseurs</a></li>
	<li><a href="produit">Gestion des produits</a></li>
</ul>

</body>
</html>