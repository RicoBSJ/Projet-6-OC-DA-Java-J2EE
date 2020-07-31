<!DOCTYPE html>
<html>
<head>
        <meta charset="utf-8" />
        <title>Creation Site</title>
        <link type="text/css" rel="stylesheet" href="<c:url value="/include/style.css"/>" />
</head>
<body>
	<c:import url="/include/menu.jsp"></c:import>
	<form method="post" action="creationSite" enctype="multipart/form-data">
            <fieldset>
                <legend>Création site</legend>
                <p>Vous pouvez créer un site via ce formulaire.</p>
                
                <input type="hidden" value="${idSite}" name="idSite">
                
				<label for="nom">Nom du site <span class="requis">*</span></label>
				<input type="text" id="nom" name="nom" value="<c:out value="${site.nom}"/>" size="30" maxlength="30" />
				<span class="erreur">${form.erreurs['nom']}</span>
                <br />
				
				<label for="pays">Pays du site <span class="requis">*</span></label>
				<input type="text" id="pays" name="pays" value="<c:out value="${site.pays}"/>" size="30" maxlength="30" />
				<span class="erreur">${form.erreurs['pays']}</span>
                <br />
                
                <label for="region">Région du site <span class="requis">*</span></label>
				<input type="text" id="region" name="region" value="<c:out value="${site.region}"/>" size="30" maxlength="30" />
				<span class="erreur">${form.erreurs['region']}</span>
                <br />
                
                <label for="cheminPhoto">Emplacement du fichier <span class="requis">*</span></label>
                <input type="file" id="cheminPhoto" name="cheminPhoto" value="<c:out value="${photo.cheminPhoto}"/>" />
                <span class="erreur">${form.erreurs['cheminPhoto']}</span>
                <br />
				
				<label for="description">Description du site <span class="requis">*</span></label>
				<input type="text" id="description" name="description" value="<c:out value="${site.description}"/>" size="30" maxlength="30" />
				<span class="erreur">${form.erreurs['description']}</span>
                <br />
                
				<label for="cotation">Cotation du site <span class="requis">*</span></label>
				<input type="text" id="cotation" name="cotation" value="<c:out value="${site.cotation}"/>" size="30" maxlength="60" />
				<span class="erreur">${form.erreurs['cotation']}</span>
                <br />
                
                <label for="hauteur">Hauteur du site <span class="requis">*</span></label>
				<input type="text" id="hauteur" name="hauteur" value="<c:out value="${site.hauteur}"/>" size="30" maxlength="60" />
				<span class="erreur">${form.erreurs['hauteur']}</span>
                <br />
                
                <label for="orientation">Orientation du site <span class="requis">*</span></label>
				<input type="text" id="orientation" name="orientation" value="<c:out value="${site.orientation}"/>" size="30" maxlength="60" />
				<span class="erreur">${form.erreurs['orientation']}</span>
                <br />
                
                <label for="secteur">Nombre de secteurs <span class="requis">*</span></label>
				<input type="text" id="secteur" name="secteur" value="<c:out value="${secteur.description}"/>" size="30" maxlength="60" />
				<span class="erreur">${form.erreurs['description']}</span>
                <br />
                
                <label for="voie">Nombre de voie <span class="requis">*</span></label>
				<input type="text" id="voie" name="voie" value="<c:out value="${voie.description}"/>" size="30" maxlength="60" />
				<span class="erreur">${form.erreurs['description']}</span>
                <br />
                
                <label for="longueur">Nombre de longueurs <span class="requis">*</span></label>
				<input type="text" id="longueur" name="longueur" value="<c:out value="${longueur.description}"/>" size="30" maxlength="60" />
				<span class="erreur">${form.erreurs['description']}</span>
                <br />

				<input type="submit" value="Valider"  />
                <input type="reset" value="Remettre à zéro" /> <br />

                <p class="${empty form.erreurs ? 'succes' : 'erreur'}">${form.resultat}</p>
            </fieldset>
	</form>
	<p><a href="<c:url value="/accueil"/>">Retour à l'accueil</a></p>
</body>
</html>