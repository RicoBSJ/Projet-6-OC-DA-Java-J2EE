<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Ajouter un topo</title>
        <link type="text/css" rel="stylesheet" href="<c:url value="/include/style.css"/>" />
    </head>
    <body>
    	<c:import url="/include/menu.jsp"></c:import>
        <form method="post" action="ajouterTopo">
            <fieldset>
                <legend>Ajouter un topo</legend>
                <p>Vous pouvez vous ajouter un topo via ce formulaire.</p>

				<label for="nom">Nom de topo <span class="requis">*</span></label>
				<input type="text" id="nom" name="nom" value="<c:out value="${topo.nom}"/>" size="20" maxlength="20" />
				<span class="erreur">${form.erreurs['nom']}</span>
                <br><br>
				
                <label for="description">Description du topo <span class="requis">*</span></label>
				<textarea name="description">${topo.description}</textarea>
				<span class="erreur">${form.erreurs['description']}</span>
				<br />

                <label for="lieu">Lieu du topo <span class="requis">*</span></label>
				<input type="text" id="lieu" name="lieu" value="<c:out value="${topo.lieu}"/>" size="20" maxlength="20" />
				<span class="erreur">${form.erreurs['lieu']}</span>
                <br />

                <label for="dateParution">Date de parution du topo <span class="requis">*</span></label>
				<input type="date" id="dateParution" name="dateParution" value="<c:out value="${topo.dateParution}"/>" size="20" maxlength="20" />
				<span class="erreur">${form.erreurs['dateParution']}</span>
                <br />
                
                <label for="site">Site du topo <span class="requis">*</span></label>
				<input type="text" id="site" name="site" value="<c:out value="${topo.site}"/>" size="20" maxlength="20" />
				<span class="erreur">${form.erreurs['site']}</span>
                <br />
                
                <input type="submit" value="Valider"  />
                <input type="reset" value="Remettre à zéro" /> <br />
                
                <p class="${empty form.erreurs ? 'succes' : 'erreur'}">${form.resultat}</p>

            </fieldset>
        </form>
        <p><a href="<c:url value="/accueil"/>">Retour à l'accueil</a></p>
    </body>
</html>