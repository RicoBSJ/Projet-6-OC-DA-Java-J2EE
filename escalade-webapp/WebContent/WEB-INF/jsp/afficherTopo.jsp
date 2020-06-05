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
			<c:if test="${sessionScope.sessionUtilisateur.membre == true}">
			<c:forEach var="topo" items="${ topo }">
				<div class="topoListe">
					<h5>${topo.nom} :</h5>
				</div>
				<div class="topoListe">
					<h5>${topo.description} :</h5>
				</div>
				<div class="topoListe">
					<h5>${topo.lieu} :</h5>
				</div>
				<div class="topoListe">
					<h5>${topo.dateParution} :</h5>
				</div>
				<div class="topoListe">
					<h5>${ topo.site } :</h5>
				</div>
				<div class="topoListe">
					<h5>${sessionScope.sessionUtilisateur.prenom} ${sessionScope.sessionUtilisateur.nom}</h5>
				</div>
			</c:forEach>
			</c:if>
		</fieldset>
	</div>
	<p>
		<a href="<c:url value="/accueil"/>">Retour à l'accueil</a>
	</p>
</body>
</html>