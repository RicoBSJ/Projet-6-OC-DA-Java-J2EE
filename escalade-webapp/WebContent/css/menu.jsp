<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div id="menu">
			<nav>
				<ul>
					<li><a href="<c:url value="/inscription"/>">Inscription</a></li>
					<li><a href="<c:url value="connexion"/>">Connexion</a></li>
					<li><a href="<c:url value="/suppressionUtilisateur"/>">Supression utlisateur</a></li>
					<li><a href="<c:url value="/listeUtilisateurs"/>">Liste utilisateurs</a></li>
					<li><a href="<c:url value="/deconnexion" />">Deconnexion</a></li>
					</c:if>
				</ul>
			</nav>
</div>