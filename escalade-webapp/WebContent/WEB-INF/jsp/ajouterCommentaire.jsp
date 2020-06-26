<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>Ajout de commentaire</title>
<link type="text/css" rel="stylesheet"
	href="<c:url value="/include/style.css"/>" />
</head>
<body>
	<c:import url="/include/menu.jsp"></c:import>
	<form action="ajouterCommentaire" method="post">
		<fieldset>
			<legend>Ajout de commentaire</legend>
			<p>Vous pouvez ajouter un commentaire via ce formulaire.</p>
			<br> <input type="hidden" value="${idSite}" name="idSite">
			<label for="titre">Ajout d'un titre <span class="requis">*</span></label>
			<input type="text" id="titre" name="titre" value="" size="30"
				maxlength="60" /> <span class="erreur">${form.erreurs['titre']}</span>
			<br> <br> <label for="contenu">Ajout de commentaire
				<span class="requis">*</span>
			</label>
			<textarea name="contenu"></textarea>
			<br> <span class="erreur">${form.erreurs['contenu']}</span> <br>

			<input type="submit" value="Valider" /> <input type="reset"
				value="Remettre à zéro" />

			<p class="${empty form.erreurs ? 'succes' : 'erreur'}">${form.resultat}</p>
		</fieldset>
	</form>
	<p>
		<a href="<c:url value="/accueil"/>">Retour à l'accueil</a>
	</p>
</body>
</html>