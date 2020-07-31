<!DOCTYPE html>
<html>
<head>
        <meta charset="utf-8" />
        <title>Recherche de Site</title>
        <link type="text/css" rel="stylesheet" href="<c:url value="/include/style.css"/>" />
</head>
<body>
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
				<input type="text" id="description" name="description" value="<c:out value="${site.description}"/>" size="30" maxlength="30" />
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
</body>
</html>