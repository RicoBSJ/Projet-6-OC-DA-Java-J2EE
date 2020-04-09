<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Affichage d'un client</title>
        <link type="text/css" rel="stylesheet" href="<c:url value="/inc/style.css"/>" />
    </head>
    <body>
        	<c:import url="../inscription" /><br>
        	<c:import url="../listeUtilisateurs" />
            <p><a href="<c:url value="/accueil"/>">Retour à l'accueil</a></p>
    </body>
</html>