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
<title>Ajout de commentaire</title>
</head>
<body>
	<div class="container">
	<c:import url="/include/menu.jsp"></c:import>
	<form action="ajouterCommentaire" method="post">
		<fieldset>
			<legend>Ajout de commentaire</legend>
			<p>Vous pouvez ajouter un commentaire via ce formulaire.</p>
			<br>
			<input type="hidden" value="${idSite}" name="idSite">
			
			<label for="titre">Ajout d'un titre <span class="requis">*</span></label>
			<input type="text" id="titre" name="titre" value="" size="30" maxlength="60" />
			<span class="erreur">${form.erreurs['titre']}</span>
			<br><br>
			
			<label for="contenu">Ajout de commentaire <span class="requis">*</span></label>
			<textarea name="contenu"></textarea>
			<span class="erreur">${form.erreurs['contenu']}</span>
			<br><br>

			<input type="submit" value="Valider" /> <input type="reset" value="Remettre à zéro" />

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