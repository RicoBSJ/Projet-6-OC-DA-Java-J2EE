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

<title>Tous les sites de l'escalade</title>
</head>
<body>
	<c:import url="/include/menu.jsp"></c:import>
	<main class="container" scope="session">
		<div id="banniere_image">
			<div id="banniere_description">
				Retour sur les tout derniers sites d'escalade... <a
					href="<c:url value="/images/escalade.png" />" class="bouton_rouge">
					Voir les commentaires <img
					src="<c:url value="/images/flecheblanchedroite.png" />" alt="" />
				</a>
			</div>
		</div>

		<section>
			<article>
				<ul>
					<c:forEach var="site" items="${ sites }">
						<article class="resultats-listeStations">
							<div class="localisationStationListe">
								<h3 class="nomStationListe">
									<a href="<c:url value="" />">${ site.nom }</a>
								</h3>
								<div class="massifListe">${ site.pays }</div>
								<div class="massifListe">${ site.region }</div>
							</div>
							<div class="thumbs-stations">
								<a href="<c:url value="/detailsSite?id=${site.id}" />">
								<img src="${ site.photos[0].cheminPhoto }" alt="Site" title="Détails du site" width="30" height="200" />
								</a>
							</div>
							<div class="results-right">
								<div class="infosStations">
									<span class="value"><span>${ site.hauteur } </span> de
										hauteur</span> <span class="value">Orientation <span>
											${ site.orientation }</span></span> <span class="value"><span>Cotation
									</span> ${ site.cotation }</span>
								</div>
							</div>
						</article>
					</c:forEach>
				</ul>
			</article>
		</section>

		<div>

			<h1>À propos des Amis de l'Escalade</h1>

			<p id="photo_du_site">
				<img src="<c:url value="/images/rock-climbing-silhouette.png" />"
					alt="Photo du site" />
			</p>
			<p>Avec l’objectif de fédérer les licenciés, l’association “Les
				amis de l’escalade” souhaite développer sa présence en ligne. À ce
				titre, plusieurs axes d’amélioration ont été identifiés dont la
				création de ce site communautaire.</p>
			<p>Ce site aura pour but la mise en relation et le partage
				d’informations. Il permettra de donner de la visibilité́ à
				l’association afin d’encourager des grimpeurs indépendants à y
				adhérer.</p>
			<p>
				<img alt="Facebook" src="<c:url value="/images/facebook.png" />" />
				<img alt="Twitter" src="<c:url value="/images/twitter.png" />" /> <img
					alt="Vimeo" src="<c:url value="/images/vimeo.png" />" /> <img
					alt="Flickr" src="<c:url value="/images/flickr.png" />" /> <img
					alt="RSS" src="<c:url value="/images/rss.png" />" />
			</p>

		</div>

		<footer>
			<div id="tweet">
				<h1>Le dernier tweet</h1>
				<p>Wow !</p>
				<p>le 12 mai à 23h12</p>
			</div>
			<div id="les_dernières_photos">
				<h1>Les dernières photos</h1>
				<p>
					<img alt="Photographie" src="<c:url value="/images/photo1.jpeg" />" />
					<img alt="Photographie" src="<c:url value="/images/photo2.jpeg" />" />
					<img alt="Photographie" src="<c:url value="/images/photo3.jpeg" />" />
					<img alt="Photographie" src="<c:url value="/images/photo4.jpeg" />" />
				</p>
			</div>
			<div id="Les_derniers_sites">
				<h1>Les derniers sites</h1>
				<div id="listes_sites">
					<ul>
						<li><a href="<c:url value="/detailsSite" />">Les Têtes
								Brûlées</a></li>
						<li><a href="<c:url value="#" />">Les Gazelles</a></li>
						<li><a href="<c:url value="#" />">Les Warriors</a></li>
						<li><a href="<c:url value="#" />">Les Irréductibles</a></li>
					</ul>
					<ul>
						<li><a href="<c:url value="#" />">Les Acrobates</a></li>
						<li><a href="<c:url value="#" />">Les Abeilles</a></li>
						<li><a href="<c:url value="#" />">Les N'importe Quoi</a></li>
						<li><a href="<c:url value="#" />">Les Fans</a></li>
					</ul>
				</div>
			</div>
		</footer>
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