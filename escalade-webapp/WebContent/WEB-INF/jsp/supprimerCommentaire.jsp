<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>Supprimer un commentaire</title>
<link type="text/css" rel="stylesheet"
	href="<c:url value="/include/style.css"/>" />
</head>
</head>
<body>
	<c:import url="/include/menu.jsp"></c:import>
	<form action="<c:url value="/supprimerCommentaire" />" method="post" enctype="multipart/form-data">
		<fieldset>
			<legend>Suppression de commentaire</legend>
			<p>Vous pouvez supprimer un commentaire via ce formulaire.</p>

			<label for="contenu">Suppression de commentaire <span
				class="requis">*</span></label> <input type="text" id="contenu"
				name="contenu" value="<c:out value="${commentaire.contenu}"/>"
				size="30" maxlength="60" /> <span class="erreur">${form.erreurs['contenu']}</span>
			<br /> <input type="submit" value="Envoyer" class="sansLabel" /> <input type="reset"
				value="Remettre à zéro" /> <br />

			<p class="${empty form.erreurs ? 'succes' : 'erreur'}">${form.resultat}</p>
		</fieldset>
	</form>
	<p>
		<a href="<c:url value="/accueil"/>">Retour à l'accueil</a>
	</p>
</body>
</html>