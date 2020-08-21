<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
<link type="text/css" rel="stylesheet"
	href="<c:url value="/include/style.css" />" />
<title>Liste des utilisateurs existants</title>
</head>
<body>
	<div class="container">
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
                    <th>Disponibilité</th>
                </tr>
                <c:forEach items="${ topos }" var="topo">
                <%-- Simple test de parité sur l'index de parcours, pour alterner la couleur de fond de chaque ligne du tableau. --%>
                <tr class="${boucle.index % 2 == 0 ? 'pair' : 'impair'}">
                    <%-- Affichage des propriétés du bean Utilisateur, qui est stocké en tant que valeur de l'entrée courante de la map --%>
                    <td><c:out value="${ topo.nom }"></c:out></td>
                    <td><c:out value="${ topo.description }"></c:out></td>
                    <td><c:out value="${ topo.lieu }"></c:out></td>
                    <td><c:out value="${ topo.dateParution }"></c:out></td>
                    <td><c:out value="${ topo.site.nom }"></c:out></td>
                    <td><c:out value="${ topo.utilisateur.nom }"></c:out></td>
					<td><c:if test="${topo.disponible == true}">
					<form action="etatTopo" method="post">
						<input type="hidden" value="${ topo.id }" name="idTopo">
						<input type="submit" name="tag" value="Disponible" />
					</form>
					</c:if>
					<c:if test="${topo.disponible == false}">
					<form action="etatTopo" method="post">
						<input type="hidden" value="${ topo.id }" name="idTopo">
						<input type="submit" name="tag" value="Non Disponible" />
					</form>
					</c:if>
					</td>
                </tr>
                </c:forEach>
            </table>
			</c:if>
		</fieldset>
	</div>
	<p>
		<a href="<c:url value="/ajouterTopo?id=${topo.id}" />">Ajouter un topo</a><br><br>
		<a href="<c:url value="/accueil"/>">Retour à l'accueil</a>
	</p>
	<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
		integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
		integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
		integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
		crossorigin="anonymous"></script>
</div>
</body>
</html>