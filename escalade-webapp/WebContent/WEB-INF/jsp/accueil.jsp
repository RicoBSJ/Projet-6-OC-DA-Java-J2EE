<%@ page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
<link type="text/css" rel="stylesheet" href="<c:url value="/css/style.css" />" />

<title>Tous les sites de l'escalade</title>
</head>
<body>
	<main class="container">
		<header>
			<div id="titre_principal">
				<div id="logo">
					<img src="<c:url value="/images/Les_amis_de_l_escalade.png" />" alt="Logo des amis de l'escalade" />
					<h1>Les Amis de l'Escalade</h1>
				</div>
				<h2>Site développé par RicoBSJ</h2>
			</div>

			<nav>
				<ul>
					<!-- Renvoyer vers des servlets -->
					<li><a href="<c:url value="/rechercheSite" />">Recherche</a></li>
					<li><a href="<c:url value="/inscription" />">Inscription</a></li>
					<li><a href="<c:url value="/connexion" />">Connexion</a></li>
				</ul>
			</nav>
		</header>

		<div id="banniere_image">
			<div id="banniere_description">
				Retour sur les tout derniers sites d'escalade... <a href="<c:url value="/images/escalade.png" />" class="bouton_rouge">
				Voir les commentaires <img src="<c:url value="/images/flecheblanchedroite.png" />" alt=""/>
				</a>
			</div>
		</div>

		<section>
			<article class="resultats-listeStations even first">

				<div class="localisationStationListe">
					<h3 class="nomStationListe">
						<a href="<c:url value="/images/tetes_brulees.jpg" />">Les Têtes Brûlées</a>
					</h3>
					<div class="massifListe">France</div>
					<div class="massifListe">Haute-Savoie</div>

				</div>
				<div class="thumbs-stations">
					<a href="<c:url value="/detailsSite" />"><img src="<c:url value="/images/tetes_brulees.jpg" />" alt="Site des Têtes Brulées" title="Détails du site Les Têtes Brulées" width="315" height="200" /></a>
				</div>

				<div class="results-right">
					<div class="infosStations">

						<span class="value"><span>80 m</span> de hauteur</span> <span>
							<span class="value">Orientation <span>Sud-Est</span></span>
						</span> <span class="value"><span>400 voies</span> de <span>4b</span>
							à <span>8b</span> </span>
					</div>
				</div>
			</article>

			<article class="resultats-listeStations odd">

				<div class="localisationStationListe">
					<h3 class="nomStationListe">
						<a ref="#" href="site-escalade-ailefroide">Les Gazelles</a>
					</h3>
					<div class="massifListe">France</div>
					<div class="massifListe">Hautes-Alpes</div>

				</div>
				<div class="thumbs-stations">
					<a ref="#" href="site-escalade-ailefroide"> <img
						src="images/gazelles.jpeg" alt="ailefroide escalade 5"
						title="ailefroide escalade 5" width="315" height="200" /></a>
				</div>

				<div class="results-right">
					<div class="infosStations">

						<span class="value"><span>De 4 m (blocs) à 400 m
								(voies)</span> de hauteur</span> <span><span class="value">Orientation
								<span>Toutes</span>
						</span></span> <span class="value"><span>500 voies</span> de <span>3a</span>
							à <span>8a</span> </span>
					</div>
				</div>

			</article>

			<article class="resultats-listeStations even">

				<div class="localisationStationListe">
					<h3 class="nomStationListe">
						<a ref="#" href="site-escalade-annot">Les Warriors</a>
					</h3>
					<div class="massifListe">France</div>
					<div class="massifListe">Alpes-de-Haute-Provence</div>

				</div>
				<div class="thumbs-stations">
					<a ref="#" href="site-escalade-annot"> <img
						src="images/warriors.jpeg" alt="annot-fred-oddo-dans-6c"
						title="annot-fred-oddo-dans-6c" width="315" height="200" /></a>
				</div>


				<div class="results-right">
					<div class="infosStations">

						<span class="value"><span>25 m</span> de hauteur</span> <span><span
							class="value">Orientation <span>Toutes</span></span></span> <span
							class="value"><span>400 voies</span> de <span>4c</span> à
							<span>8c+</span> </span>
					</div>
				</div>
			</article>

		</section>

		<section>
			<article>
				<h2>Liste des sites répertoriés</h2>

				<ul>
					<c:forEach var="site" items="${ sites }">
						<li><c:out value="${ site.nomSite }" /></li>
					</c:forEach>
				</ul>
			</article>
		</section>

		<div>

			<h1>À propos des Amis de l'Escalade</h1>

			<p id="photo_du_site">
				<img src="<c:url value="/images/rock-climbing-silhouette.png" />" alt="Photo du site" />
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
				<img alt="Twitter" src="<c:url value="/images/twitter.png" />" />
				<img alt="Vimeo" src="<c:url value="/images/vimeo.png" />" />
				<img alt="Flickr" src="<c:url value="/images/flickr.png" />" />
				<img alt="RSS" src="<c:url value="/images/rss.png" />" />
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
						<li><a href="<c:url value="#" />">Les Têtes Brûlées</a></li>
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