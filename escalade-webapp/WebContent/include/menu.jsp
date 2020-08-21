<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
<link type="text/css" rel="stylesheet"
	href="<c:url value="/include/style.css" />" />
<title>Les Amis de l'Escalade</title>
</head>
<body>
<div id="menu" class="container">
	<header class="row">
		<div id="titre_principal" class="col">
			<div id="logo">
				<img src="<c:url value="/images/Les_amis_de_l_escalade.png"/>"
					alt="Logo des amis de l'escalade" />
				<h1>Les Amis de l'Escalade</h1>
			</div>
			<h2>Site développé par RicoBSJ</h2>
		</div>

		<nav class="col">
			<ul class="col">
				<c:if test="${empty sessionScope.sessionUtilisateur}">
					<li><a href="<c:url value="/rechercheSite" />">Recherche site</a></li>
					<li><a href="<c:url value="/inscription" />">Inscription</a></li>
					<li><a href="<c:url value="/connexion" />">Connexion</a></li>
				</c:if>
				<c:if test="${!empty sessionScope.sessionUtilisateur}">
					<li>${sessionScope.sessionUtilisateur.prenom} ${sessionScope.sessionUtilisateur.nom}</li>
					<c:if test="${sessionScope.sessionUtilisateur.membre == true}">
						<li><font color="red">Membre officiel</font></li>
					</c:if>
					<li><a href="<c:url value="/rechercheSite" />">Recherche site</a></li>
					<li><a href="<c:url value="/creationSite" />">Création site</a></li>
					<li><a href="<c:url value="/listeUtilisateurs" />">Liste Utilisateurs</a></li>
					<li><a href="<c:url value="/afficherToposUtilisateur" />">Topo(s) utilisateur</a></li>
					<li><a href="<c:url value="/afficherToposDisponibles" />">Topo(s) disponible(s)</a></li>
					<li><a href="<c:url value="/afficherMessagesUtilisateur" />">Message(s)</a></li>
					<li><a href="<c:url value="/deconnexion" />">Deconnexion</a></li>
					
				</c:if>
			</ul>
		</nav>
	</header>
</div>
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
</body>
</html>