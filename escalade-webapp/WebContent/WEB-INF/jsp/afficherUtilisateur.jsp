<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Affichage d'un utilisateur</title>
        <link type="text/css" rel="stylesheet" href="<c:url value="/include/style.css"/>" />
    </head>
    <body>
        <c:import url="/include/menu.jsp" />
        <div id="corps">
            <p class="info">${ form.resultat }</p>
            <p>Nom : <c:out value="${ utilisateur.nom }"/></p>
            <p>Prénom : <c:out value="${ utilisateur.prenom }"/></p>
            <p>Adresse : <c:out value="${ utilisateur.adresse }"/></p>
            <p>Numéro de téléphone : <c:out value="${ utilisateur.telephone }"/></p>
            <p>Email : <c:out value="${ utilisateur.email }"/></p>
        </div>
    </body>
</html>