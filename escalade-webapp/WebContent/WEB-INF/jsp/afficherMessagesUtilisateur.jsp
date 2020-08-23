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
<title>Liste des messages de l'utilisateur connecté</title>
</head>
<body>
	<div class="container">
	<c:import url="/include/menu.jsp"></c:import>
	<div id="corps">
		<fieldset>
			<legend>Liste des messages de l'utilisateur connecté</legend>
			<c:if test="${!empty sessionScope.sessionUtilisateur}">
			<table>
                <tr>
                    <th>Demandeur</th>
                    <th>Message</th>
                    <th>Topo</th>
                    <th>Réservation</th>
                </tr>
                <c:forEach items="${ messages }" var="message">
                <tr class="${boucle.index % 2 == 0 ? 'pair' : 'impair'}">
                    <td><c:out value="${ message.emetteur.nom }"></c:out></td>
                    <td><c:out value="${ message.message }"></c:out></td>
                    <td><c:out value="${ message.topo.nom }"></c:out></td>
                    <td>
                    <form action="etatTopo" method="post">
						<input type="hidden" value="${ message.topo.id }" name="idTopo">
						<input type="submit" name="tag" value="Accepter la demande de réservation" />
					</form>
					<form action="etatTopo" method="post">
						<input type="hidden" value="${ message.topo.id }" name="idTopo">
						<input type="submit" name="tag" value="Refuser la demande de réservation" />
					</form>
					</td>
                </tr>
                </c:forEach>
            </table>
			</c:if>
		</fieldset>
	</div>
	<p>
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