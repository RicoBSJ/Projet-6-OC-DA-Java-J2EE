<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>Liste des messages de l'utilisateur connecté</title>
<link type="text/css" rel="stylesheet"
	href="<c:url value="/include/style.css"></c:url>" />
</head>
<body>
	<c:import url="/include/menu.jsp"></c:import>
	<div id="corps">
		<fieldset>
			<legend>Liste des messages de l'utilisateur connecté</legend>
			<c:if test="${!empty sessionScope.sessionUtilisateur}">
			<table>
                <tr>
                    <th>Emetteur</th>
                    <th>Message</th>
                    <th>Topo</th>
                    <th>Réservation</th>
                </tr>
                <c:forEach items="${ messages }" var="message">
                <tr class="${boucle.index % 2 == 0 ? 'pair' : 'impair'}">
                    <td><c:out value="${ message.emetteur }"></c:out></td>
                    <td><c:out value="${ message.message }"></c:out></td>
                    <td><c:out value="${ message.topo }"></c:out></td>
					<td><c:if test="${topo.disponible == true}">
					<form action="accepterDemandeReservation" method="post">
						<input type="hidden" value="${ message.id }" name="message">
						<input type="submit" name="tag" value="Accepter la demande de réservation de topo" />
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
		<a href="<c:url value="/accueil"/>">Retour à l'accueil</a>
	</p>
</body>
</html>