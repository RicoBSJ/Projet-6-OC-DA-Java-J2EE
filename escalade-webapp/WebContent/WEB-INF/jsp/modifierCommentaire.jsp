<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
<link type="text/css" rel="stylesheet"
	href="<c:url value="/include/style.css" />" />
<title>Modification de commentaire</title>
</head>
</head>
<body>
	<div class="container">
	<c:import url="/include/menu.jsp"></c:import>
	<form action="modifierCommentaire" method="post">
		<fieldset>
			<legend>Modifier un commentaire</legend>
			<p>Vous pouvez modifier un commentaire via ce formulaire.</p>

			<input type="hidden" value="${commentaire.idCommentaire}" name="id">
			<label for="titre">Modification du titre <span class="requis">*</span></label>
			<input name="titre" type="text" value="${commentaire.titre}"><br><br>
			<span class="erreur">${form.erreurs['titre']}</span>
			<label for="contenu">Modification de commentaire <span class="requis">*</span></label>
			<textarea name="contenu">${commentaire.contenu}</textarea><br>
			<span class="erreur">${form.erreurs['contenu']}</span>
			<br /> <input type="submit" value="Envoyer" class="sansLabel" /> <input type="reset"
				value="Remettre à zéro" /> <br />

			<p class="${empty form.erreurs ? 'succes' : 'erreur'}">${form.resultat}</p>
		</fieldset>
	</form>
	<p>
		<a href="<c:url value="/accueil"/>">Retour à l'accueil</a>
	</p>
	<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
		integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
		integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
		integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
		crossorigin="anonymous"></script>
	</div>
</body>
</html>