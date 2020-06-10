<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Liste des utilisateurs existants</title>
        <link type="text/css" rel="stylesheet" href="<c:url value="/include/style.css"></c:url>" />
    </head>
    <body>
        <c:import url="/include/menu.jsp"></c:import>
        <div id="corps">
        <fieldset>
        <legend>Liste des utilisateurs existants</legend>
            <table>
                <tr>
                    <th>Nom</th>
                    <th>Pr�nom</th>
                    <th>Adresse</th>
                    <th>T�l�phone</th>
                    <th>Email</th>
                    <th>Membre</th>
                </tr>
                <c:forEach items="${ utilisateurs }" var="utilisateur">
                <%-- Simple test de parit� sur l'index de parcours, pour alterner la couleur de fond de chaque ligne du tableau. --%>
                <tr class="${boucle.index % 2 == 0 ? 'pair' : 'impair'}">
                    <%-- Affichage des propri�t�s du bean Utilisateur, qui est stock� en tant que valeur de l'entr�e courante de la map --%>
                    <td><c:out value="${ utilisateur.nom }"></c:out></td>
                    <td><c:out value="${ utilisateur.prenom }"></c:out></td>
                    <td><c:out value="${ utilisateur.adresse }"></c:out></td>
                    <td><c:out value="${ utilisateur.telephone }"></c:out></td>
                    <td><c:out value="${ utilisateur.email }"></c:out></td>
                    <td><c:if test="${utilisateur.membre == true}"><h5>Membre officiel</h5></c:if></td>
                </tr>
                </c:forEach>
            </table>
        </fieldset>
        </div>
        <p><a href="<c:url value="/accueil"/>">Retour � l'accueil</a></p>
    </body>
</html>