<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>Liste des utilisateurs existants</title>
<link type="text/css" rel="stylesheet"
	href="<c:url value="/include/style.css"></c:url>" />
</head>
<body>
	<c:import url="/include/menu.jsp"></c:import>
	<div id="corps">
		<fieldset>
			<legend>Liste des topos de l'utilisateur connecté</legend>
			<c:if test="${!empty sessionScope.sessionUtilisateur}">
			<table>
                <tr>
                    <th>Nom</th>
                    <th>Description</th>
                    <th>Lieu</th>
                    <th>Date de parution</th>
                    <th>Site du topo</th>
                    <th>Utilisateur</th>
                </tr>
                <c:forEach items="${ topo }" var="topo">
                <%-- Simple test de parité sur l'index de parcours, pour alterner la couleur de fond de chaque ligne du tableau. --%>
                <tr class="${boucle.index % 2 == 0 ? 'pair' : 'impair'}">
                    <%-- Affichage des propriétés du bean Utilisateur, qui est stocké en tant que valeur de l'entrée courante de la map --%>
                    <td><c:out value="${ topo.nom }"></c:out></td>
                    <td><c:out value="${ topo.description }"></c:out></td>
                    <td><c:out value="${ topo.lieu }"></c:out></td>
                    <td><c:out value="${ topo.dateParution }"></c:out></td>
                    <td><c:out value="${ topo.site.nom }"></c:out></td>
                    <td><c:out value="${ topo.utilisateur.nom }"></c:out></td>
                </tr>
                </c:forEach>
            </table>
			</c:if>
		</fieldset>
	</div>
	<p>
		<a href="<c:url value="/accueil"/>">Retour à l'accueil</a>
	</p>
</body>
</html>