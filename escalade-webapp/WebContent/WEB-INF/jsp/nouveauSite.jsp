<!DOCTYPE html>
<html>
<head>
        <meta charset="utf-8" />
        <title>Creation Site</title>
        <link type="text/css" rel="stylesheet" href="<c:url value="/include/style.css"/>" />
</head>
<body>
	<form method="post" action="creationSite" enctype="multipart/form-data">
            <fieldset>
                <legend>Cr�ation site</legend>
                <p>Vous pouvez cr�er un site via ce formulaire.</p>
                
				<label for="nom">Nom du site <span class="requis">*</span></label>
				<input type="text" id="nom" name="nom" value="<c:out value="${site.nom}"/>" size="30" maxlength="30" />
				<span class="erreur">${form.erreurs['nom']}</span>
                <br />
				
				<label for="pays">Pays du site <span class="requis">*</span></label>
				<input type="text" id="pays" name="pays" value="<c:out value="${site.pays}"/>" size="30" maxlength="30" />
				<span class="erreur">${form.erreurs['pays']}</span>
                <br />
                
                <label for="region">R�gion du site <span class="requis">*</span></label>
				<input type="text" id="region" name="region" value="<c:out value="${site.region}"/>" size="30" maxlength="30" />
				<span class="erreur">${form.erreurs['region']}</span>
                <br />
                
                <label for="nomPhoto">Description du fichier</label>
                <input type="text" id="nomPhoto" name="nomPhoto" value="<c:out value="${photo.nomPhoto}"/>" />
                <span class="erreur">${form.erreurs['nomPhoto']}</span>
                <br />
                
                <label for="fichier">Emplacement du fichier <span class="requis">*</span></label>
                <input type="file" id="fichier" name="fichier" value="<c:out value="${photo.cheminPhoto}"/>" />
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

				<input type="submit" value="Valider"  />
                <input type="reset" value="Remettre � z�ro" /> <br />
                
                <p class="${empty form.erreurs ? 'succes' : 'erreur'}">${form.resultat}</p>
            </fieldset>
	</form>
	<p><a href="<c:url value="/accueil"/>">Retour � l'accueil</a></p>
</body>
</html>