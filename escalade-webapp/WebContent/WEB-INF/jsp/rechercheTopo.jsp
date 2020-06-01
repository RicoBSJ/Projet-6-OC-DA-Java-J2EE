<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
        <meta charset="utf-8" />
        <title>Recherche de Site</title>
        <link type="text/css" rel="stylesheet" href="<c:url value="/include/style.css"/>" />
</head>
<body>
	<c:import url="/include/menu.jsp"></c:import>
	<form method="post" action="rechercheTopo">
            <fieldset>
                <legend>Recherche de topo</legend>
                <p>Vous pouvez sélectionner vos critères de recherche via ce formulaire.</p>
                
				<label for="nom">Recherche de topos par nom </label>
				<input type="text" id="nom" name="nom" value="<c:out value="${topo.nom}"/>" size="30" maxlength="30" />
				<span class="erreur">${form.erreurs['nom']}</span>
                <br />

				<label for="description">Recherche de topos par description </label>
				<input type="text" id="description" name="description" value="<c:out value="${topo.description}"/>" size="30" maxlength="30" />
				<span class="erreur">${form.erreurs['description']}</span>
                <br />
                
				<label for="dateParution">Recherche de topos par date de parution </label>
				<input type="date" id="dateParution" name="dateParution" value="<c:out value="${topo.dateParution}"/>" size="30" maxlength="60" />
				<span class="erreur">${form.erreurs['dateParution']}</span>
                <br />

                <input type="submit" value="Valider"  />
                <input type="reset" value="Remettre à zéro" /> <br />
                
                <p class="${empty form.erreurs ? 'succes' : 'erreur'}">${form.resultat}</p>
            </fieldset>
	</form>
	<p><a href="<c:url value="/accueil"/>">Retour à l'accueil</a></p>
</body>
</html>