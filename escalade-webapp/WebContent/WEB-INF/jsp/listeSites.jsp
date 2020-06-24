<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Liste des sites existants</title>
        <link type="text/css" rel="stylesheet" href="<c:url value="/include/style.css"/>" />
    </head>
    <body>
        <c:import url="/include/menu.jsp" />
        <div id="corps">
        <c:choose>
            <%-- Si aucun site n'existe en session, affichage d'un message par défaut. --%>
            <c:when test="${ empty sessionScope.sites }">
                <p class="erreur">Aucun site enregistré.</p>
            </c:when>
            <%-- Sinon, affichage du tableau. --%>
            <c:otherwise>
            <table>
                <tr>
                    <th>Nom</th>
                    <th>Pays</th>
                    <th>Region</th>               
                </tr>
                <%-- Parcours de la Map des sites en session, et utilisation de l'objet varStatus. --%>
                <c:forEach items="${ sessionScope.sites }" var="mapSites" varStatus="boucle">
                <%-- Simple test de parité sur l'index de parcours, pour alterner la couleur de fond de chaque ligne du tableau. --%>
                <tr class="${boucle.index % 2 == 0 ? 'pair' : 'impair'}">
                    <%-- Affichage des propriétés du bean Site, qui est stocké en tant que valeur de l'entrée courante de la map --%>
                    <td><c:out value="${ mapSites.value.nom }"/></td>
                    <td><c:out value="${ mapSites.value.pays }"/></td>
                    <td><c:out value="${ mapSites.value.region }"/></td>
                </tr>
                </c:forEach>
            </table>
            </c:otherwise>
        </c:choose>
        </div>
    </body>
</html>