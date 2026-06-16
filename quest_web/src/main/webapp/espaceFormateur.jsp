<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Gestion Formateur</title>
</head>
<body>

<h1>Bienvenue ${connected.login} sur votre page de gestion formateur</h1>


<p>Site en construction</p>


<p>Changement de vos infos (update partiel)</p>

<form action="formateur/updatePartiel"  method="post" class="form-clean">
<input type="hidden" value="${connected.id}">
	<input required type="password" name="password" placeholder="Saisir le password">
	<input required type="password" name="passwordConfirm" placeholder="Saisir à nouveau le password">
	<input type="submit" value="Changer le password">
</form>

</body>
</html>
