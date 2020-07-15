<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>Liste des messages de l'utilisateur connect�</title>
<link type="text/css" rel="stylesheet"
	href="<c:url value="/include/style.css"></c:url>" />
</head>
<body>
	<c:import url="/include/menu.jsp"></c:import>
	<div id="corps">
		<fieldset>
			<legend>Liste des messages de l'utilisateur connect�</legend>
			<c:if test="${!empty sessionScope.sessionUtilisateur}">
			<table>
                <tr>
                    <th>Demandeur</th>
                    <th>Message</th>
                    <th>Topo</th>
                    <th>R�servation</th>
                </tr>
                <c:forEach items="${ messages }" var="message">
                <tr class="${boucle.index % 2 == 0 ? 'pair' : 'impair'}">
                    <td><c:out value="${ message.emetteur.nom }"></c:out></td>
                    <td><c:out value="${ message.message }"></c:out></td>
                    <td><c:out value="${ message.topo.nom }"></c:out></td>
					<td><c:if test="${message.topo.disponible == true}">
					<form action="accepterDemandeReservation" method="post">
						<input type="hidden" value="${ message.emetteur.id }" name="idUser">
						<input type="hidden" value="${ message.topo.id }" name="idDispo">
						<input type="submit" name="tag" value="Accepter la demande de r�servation de topo" />
					</form>
<%-- 					<a href="<c:url value="/accepterDemandeReservation?idDispo=${topo.id}" />">Accepter la demande de r�servation de topo</a> --%>
<%-- 					<input type="hidden" value="${ utilisateur.id }" name="idUser"> --%>
					</c:if>
					</td>
                </tr>
                </c:forEach>
            </table>
			</c:if>
		</fieldset>
	</div>
	<p>
		<a href="<c:url value="/accueil"/>">Retour � l'accueil</a>
	</p>
</body>
</html>