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
        <title>Recherche de Site</title>
</head>
<body>
	<div class="container">
	<c:import url="/include/menu.jsp"></c:import>
	<form method="post" action="rechercheSite">
            <fieldset>
                <legend>Recherche de site</legend>
                <p>Vous pouvez sélectionner vos critères de recherche via ce formulaire.</p>
                
				<label for="nom">Recherche de site par nom </label>
				<input type="text" id="nom" name="nom" value="<c:out value="${site.nom}"/>" size="30" maxlength="30" />
				<span class="erreur">${form.erreurs['nom']}</span>
                <br />
				
				<label for="pays">Recherche de site par pays </label>
				<input type="text" id="pays" name="pays" value="<c:out value="${site.pays}"/>" size="30" maxlength="30" />
				<span class="erreur">${form.erreurs['pays']}</span>
                <br />
                
                <label for="region">Recherche de site par région </label>
				<input type="text" id="region" name="region" value="<c:out value="${site.region}"/>" size="30" maxlength="30" />
				<span class="erreur">${form.erreurs['region']}</span>
                <br />

				<label for="description">Recherche de site par description </label>
				<textarea name="description"></textarea>
				<span class="erreur">${form.erreurs['description']}</span>
                <br />
                
				<label for="cotation">Recherche de site par cotation </label>
				<input type="text" id="cotation" name="cotation" value="<c:out value="${site.cotation}"/>" size="30" maxlength="60" />
				<span class="erreur">${form.erreurs['cotation']}</span>
                <br />
                
                <label for="hauteur">Recherche de site par hauteur </label>
				<input type="text" id="hauteur" name="hauteur" value="<c:out value="${site.hauteur}"/>" size="30" maxlength="60" />
				<span class="erreur">${form.erreurs['hauteur']}</span>
                <br />
                
                <label for="orientation">Recherche de site par orientation </label>
				<input type="text" id="orientation" name="orientation" value="<c:out value="${site.orientation}"/>" size="30" maxlength="60" />
				<span class="erreur">${form.erreurs['orientation']}</span>
                <br />
                
                <label for="secteurs">Recherche de site par secteur </label>
				<input type="text" id="secteurs" name="secteurs" value="<c:out value="${site.secteurs}"/>" size="30" maxlength="60" />
				<span class="erreur">${form.erreurs['secteurs']}</span>
                <br />
                
                <label for="voies">Recherche de site par voie </label>
				<input type="text" id="voies" name="voies" value="<c:out value="${site.voies}"/>" size="30" maxlength="60" />
				<span class="erreur">${form.erreurs['voies']}</span>
                <br />
                
                <label for="longueurs">Recherche de site par longueur </label>
				<input type="text" id="longueurs" name="longueurs" value="<c:out value="${site.longueurs}"/>" size="30" maxlength="60" />
				<span class="erreur">${form.erreurs['longueurs']}</span>
                <br />

                <input type="submit" value="Valider"  />
                <input type="reset" value="Remettre à zéro" /> <br />
                
                <p class="${empty form.erreurs ? 'succes' : 'erreur'}">${form.resultat}</p>
            </fieldset>
	</form>
	<p><a href="<c:url value="/accueil"/>">Retour à l'accueil</a></p>
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