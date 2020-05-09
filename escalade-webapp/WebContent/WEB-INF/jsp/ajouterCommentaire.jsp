<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
        <meta charset="utf-8" />
        <title>Ajout de commentaire</title>
        <link type="text/css" rel="stylesheet" href="<c:url value="/include/style.css"/>" />
</head>
</head>
<body>
	<c:import url="/include/menu.jsp"></c:import>
	<form method="post" action="creationSite">
            <fieldset>
                <legend>Ajout de commentaire</legend>
                <p>Vous pouvez ajouter un commentaire via ce formulaire.</p>
                
                <label for="commentaire">Ajout de commentaire <span class="requis">*</span></label>
				<input type="text" id="commentaire" name="commentaire" value="<c:out value="${commentaire.commentaire}"/>" size="30" maxlength="60" />
				<span class="erreur">${form.erreurs['commentaire']}</span>
                <br />

                <input type="submit" value="Valider"  />
                <input type="reset" value="Remettre à zéro" /> <br />
                
                <p class="${empty form.erreurs ? 'succes' : 'erreur'}">${form.resultat}</p>
            </fieldset>
	</form>
	<p><a href="<c:url value="/accueil"/>">Retour à l'accueil</a></p>
</body>
</html>