<%@ page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<link type="text/css" rel="stylesheet" href="css/style.css" />
<style type="text/css">
body {
	background: url('images/fond_jaune.png');
	font-family: 'Trebuchet MS', Arial, sans-serif;
	color: #181818;
}

#banniere_image {
	margin-top: 15px;
	height: 200px;
	border-radius: 5px;
	background: url('images/escalade_grand.png') no-repeat;
	position: relative;
	box-shadow: 0px 4px 4px #1c1a19;
	margin-bottom: 25px;
}
</style>
<title>Tous les sites de l'escalade</title>
</head>
<body>

	<article id="bloc_page">
		<header>
			<div id="titre_principal">
				<div id="logo">
					<img src="images/Les_amis_de_l_escalade.png"
						alt="Logo des amis de l'escalade" />
					<h1>Les Amis de l'Escalade</h1>
				</div>
				<h2>Site développé par RicoBSJ</h2>
			</div>

			<nav>
				<ul>
					<li><a href="/accueil.jsp">Accueil</a></li>
					<li><a href="/rechercheSite.jsp">Recherche</a></li>
				</ul>
			</nav>
		</header>

		<div id="banniere_image">
			<div id="banniere_description">
				Retour sur les tout derniers sites d'escalade... <a
					href="images/escalade.png" class="bouton_rouge">Voir les
					commentaires <img src="images/flecheblanchedroite.png" alt="" />
				</a>
			</div>
		</div>
	</article>

	<section>
		<article class="resultats-listeStations even first">

			<div class="localisationStationListe">
				<h3 class="nomStationListe">
					<a ref="#" href="site-escalade-ablon">Les Têtes Brûlées</a>
				</h3>
				<div class="massifListe">France</div>
				<div class="massifListe">Haute-Savoie</div>

			</div>
			<div class="thumbs-stations">
				<a ref="#" href="site-escalade-ablon"> <img
					src="images/tetes_brulees.jpg" alt="marc daviet ablon"
					title="marc daviet ablon" width="315" height="200" />
				</a>
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
						class="value"><span>400 voies</span> de <span>4c</span> à <span>8c+</span>
					</span>
				</div>
			</div>
		</article>

	</section>

	<section>
		<article>
			<li>
				<h1>Liste des sites répertoriés</h1>

				<ul>
					<c:forEach var="site" items="${ sites }">
						<li><c:out value="${ site.nomSite }" /></li>
					</c:forEach>
				</ul>
			</li>
		</article>
	</section>

	<div>

		<h1>À propos des Amis de l'Escalade</h1>

		<p id="photo_du_site">
			<img src="images/rock-climbing-silhouette.png" alt="Photo du site" />
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
			<img src="images/facebook.png" alt="Facebook" /><img
				src="images/twitter.png" alt="Twitter" /><img
				src="images/vimeo.png" alt="Vimeo" /><img src="images/flickr.png"
				alt="Flickr" /><img src="images/rss.png" alt="RSS" />
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
				<img src="images/photo1.jpeg" alt="Photographie" /><img
					src="images/photo2.jpeg" alt="Photographie" /><img
					src="images/photo3.jpeg" alt="Photographie" /><img
					src="images/photo4.jpeg" alt="Photographie" />
			</p>
		</div>
		<div id="Les_derniers_sites">
			<h1>Les derniers sites</h1>
			<div id="listes_sites">
				<ul>
					<li><a href="#">Les Têtes Brûlées</a></li>
					<li><a href="#">Les Gazelles</a></li>
					<li><a href="#">Les Warriors</a></li>
					<li><a href="#">Les Irréductibles</a></li>
				</ul>
				<ul>
					<li><a href="#">Les Acrobates</a></li>
					<li><a href="#">Les Abeilles</a></li>
					<li><a href="#">Les N'importe Quoi</a></li>
					<li><a href="#">Les Fans</a></li>
				</ul>
			</div>
		</div>
	</footer>
</body>
</html>