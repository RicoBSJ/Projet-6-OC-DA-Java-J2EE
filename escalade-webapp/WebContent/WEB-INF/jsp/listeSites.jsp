<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Liste des sites</title>
        <link type="text/css" rel="stylesheet" href="<c:url value="/include/style.css"></c:url>" />
    </head>
    <body>
        <c:import url="/include/menu.jsp"></c:import>
        <div id="corps">
        <fieldset>
        <legend>Liste des sites</legend>
            <table>
                <tr>
                    <th>Nom</th>
                    <th>Pays</th>
                    <th>Region</th>
                </tr>
                <c:forEach items="${ sites }" var="site">
                <%-- Simple test de parité sur l'index de parcours, pour alterner la couleur de fond de chaque ligne du tableau. --%>
                <tr class="${boucle.index % 2 == 0 ? 'pair' : 'impair'}">
                    <%-- Affichage des propriétés du bean Utilisateur, qui est stocké en tant que valeur de l'entrée courante de la map --%>
                    <td><c:out value="${ site.nom }"></c:out></td>
                    <td><c:out value="${ site.pays }"></c:out></td>
                    <td><c:out value="${ site.region }"></c:out></td>
                </tr>
                </c:forEach>
            </table>
        </fieldset>
        </div>
        <p><a href="<c:url value="/accueil"/>">Retour à l'accueil</a></p>
    </body>
</html>