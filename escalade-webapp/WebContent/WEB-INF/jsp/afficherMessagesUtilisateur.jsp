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
					<td><c:if test="${message.topo.disponible == true}">
						<a href="<c:url value="/accepterDemandeReservation?idDispo=${message.topo.id}" />">Accepter la demande de réservation de topo</a>
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