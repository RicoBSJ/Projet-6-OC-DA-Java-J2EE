<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Liste des utilisateurs existants</title>
        <link type="text/css" rel="stylesheet" href="<c:url value="/css/style.css"></c:url>" />
    </head>
    <body>
        <c:import url="/css/menu.jsp" ></c:import>
        <div id="corps">
        <c:choose>
            <%-- Si aucun utilisateur n'existe en session, affichage d'un message par défaut. --%>
            <c:when test="${ empty sessionScope.utilisateurs }">
                <p class="erreur">Aucun utilisateur enregistré.</p>
            </c:when>
            <%-- Sinon, affichage du tableau. --%>
            <c:otherwise>
            <table>
                <tr>
                    <th>Nom</th>
                    <th>Prénom</th>
                    <th>Adresse</th>
                    <th>Téléphone</th>
                    <th>Email</th>
                    <th class="action">Action</th>                    
                </tr>
                <%-- Parcours de la Map des utilisateurs en session, et utilisation de l'objet varStatus. --%>
                <c:forEach items="${ sessionScope.utilisateurs }" var="mapUtilisateurs" varStatus="boucle">
                <%-- Simple test de parité sur l'index de parcours, pour alterner la couleur de fond de chaque ligne du tableau. --%>
                <tr class="${boucle.index % 2 == 0 ? 'pair' : 'impair'}">
                    <%-- Affichage des propriétés du bean Utilisateur, qui est stocké en tant que valeur de l'entrée courante de la map --%>
                    <td><c:out value="${ mapUtilisateurs.value.nom }"></c:out></td>
                    <td><c:out value="${ mapUtilisateurs.value.prenom }"></c:out></td>
                    <td><c:out value="${ mapUtilisateurs.value.adresse }"></c:out></td>
                    <td><c:out value="${ mapUtilisateurs.value.telephone }"></c:out></td>
                    <td><c:out value="${ mapUtilisateurs.value.email }"></c:out></td>

                    <%-- Lien vers la servlet de suppression, avec passage du nom du utilisateur - c'est-à-dire la clé de la Map - en paramètre grâce à la balise <c:param></c:param>. --%>
                    <td class="action">
                        <a href="<c:url value="/suppressionUtilisateur"><c:param name="idUtilisateur" value="${ mapUtilisateurs.key }" ></c:param></c:url>">
                            <img src="<c:url value="/inc/supprimer.png"></c:url>" alt="Supprimer" />
                        </a>
                    </td>
                </tr>
                </c:forEach>
            </table>
            </c:otherwise>
        </c:choose>
        </div>
    </body>
</html>