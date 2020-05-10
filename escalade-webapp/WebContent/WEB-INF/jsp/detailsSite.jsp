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
<title>${ site.nom}</title>
</head>
<body>
	<c:import url="/include/menu.jsp"></c:import>
	<main class="container">
		<section>
			<article class="resultats-listeStations even">
				<div class="localisationStationListe">
					<h3 class="nomStationListe">
						<a href="<c:url value="" />">${ site.nom }</a> <a
							href="<c:url value="/accueil"/>">Retour accueil</a>
					</h3>
					<div class="massifListe">${ site.pays }</div>
					<div class="massifListe">${ site.region }</div>
				</div>
				<div class="thumbs-stations">
					<img src="${ site.photos[0].cheminPhoto }" alt="Site"
						title="Détails du site" width="315" height="200" />
					<h5>Description du site</h5>
					<div class="massifListe">${ site.description }</div>
					<h5>Commentaires</h5>
					<div class="massifListe"><h5>${ site.commentaires[0].commentaires.prenom }</h5></div>
					<div class="massifListe"><h5>${ site.commentaires[0].commentaires.nom }</h5></div>
					<div class="massifListe">${ site.commentaires[0].commentaire }</div>
				</div>

				<div class="results-right">
					<div class="infosStations">
						<span class="value"><span>${ site.hauteur } </span> de
							hauteur</span> <span class="value">Orientation <span> ${ site.orientation }</span></span>
						<span class="value"><span>Cotation </span> ${ site.cotation }</span>
					</div>
				</div>
			</article>
		</section>

	</main>
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