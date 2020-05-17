<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div id="menu">
	<header>
		<div id="titre_principal">
			<div id="logo">
				<img src="<c:url value="/images/Les_amis_de_l_escalade.png"/>"
					alt="Logo des amis de l'escalade" />
				<h1>Les Amis de l'Escalade</h1>
			</div>
			<h2>Site développé par RicoBSJ</h2>
		</div>

		<nav>
			<ul>
				<c:if test="${empty sessionScope.sessionUtilisateur}">
					<li><a href="<c:url value="/inscription" />">Inscription</a></li>
					<li><a href="<c:url value="/connexion" />">Connexion</a></li>
				</c:if>
				<li><a href="<c:url value="/listeUtilisateurs" />">Liste</a></li>
				<li><a href="<c:url value="/rechercheSite" />">Recherche de site</a></li>
				<c:if test="${!empty sessionScope.sessionUtilisateur}">
					<li>${sessionScope.sessionUtilisateur.prenom} ${sessionScope.sessionUtilisateur.nom}</li>
					<li><a href="<c:url value="/creationSite" />">Création d'un site</a></li>
					<li><a href="<c:url value="/deconnexion" />">Deconnexion</a></li>
				</c:if>
			</ul>
		</nav>
	</header>
</div>