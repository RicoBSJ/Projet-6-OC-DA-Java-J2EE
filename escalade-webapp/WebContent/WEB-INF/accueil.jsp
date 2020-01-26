<%@ page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<link type="text/css" rel="stylesheet" href="css/style.css" />
<!-- Pour tout le monde -->
<link rel="stylesheet" media="screen and (max-width: 1280px)"
	href="petite_resolution.css" />
<!-- Pour ceux qui ont une résolution inférieure à 1280px -->
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

	<div id="bloc_page">
		<header>
			<div id="titre_principal">
				<div id="logo">
					<img src="images/Les amis de l'escalade.png"
						alt="Logo des amis de l'escalade" />
					<h1>Les Amis de l'Escalade</h1>
				</div>
				<h2>Site développé par RicoBSJ</h2>
			</div>

			<nav>
				<ul>
					<li><a href="/accueil.jsp">Accueil</a></li>
					<li><a href="/ajouterSite.jsp">Recherche</a></li>
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

		<section>

			<article>
				<h1>Nom du site d'escalade : Les Têtes Brûlées</h1>
				<h1>Localisation</h1>
				<h1>Pays</h1>
				<h1>
					<a
						href="https://www.grimper.com/media/020/01/baroud__crop_250x170.jpg">Photo</a>
				</h1>
			</article>

			<article>
				<h1>Nom du site d'escalade : Les Gazelles</h1>
				<h1>Localisation</h1>
				<h1>Pays</h1>
				<h1>
					<a
						href="https://www.grimper.com/media/020/01/bigfish__crop_355x198.jpg">Photo</a>
				</h1>
			</article>

			<article>
				<h1>Nom du site d'escalade : Les Warriors</h1>
				<h1>Localisation</h1>
				<h1>Pays</h1>
				<h1>
					<a
						href="https://www.grimper.com/media/020/01/chastagnier__crop_250x170.jpg">Photo</a>
				</h1>
			</article>
		</section>

		<section>
			<h1>Liste des sites répertoriés</h1>
		</section>

		<ul>
			<c:forEach var="site" items="${ sites }">
				<li><c:out value="${ site.nomSite }" /></li>
			</c:forEach>
		</ul>

	</div>

	<section>

		<aside>
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
		</aside>
	</section>

	<footer>
		<div id="tweet">
			<h1>Le dernier tweet</h1>
			<p>Wow !</p>
			<p>le 12 mai à 23h12</p>
		</div>
		<div id="les_dernières_photos">
			<h1>Les dernières photos</h1>
			<p>
				<img src="images/photo1.jpg" alt="Photographie" /><img
					src="images/photo2.jpg" alt="Photographie" /><img
					src="images/photo3.jpg" alt="Photographie" /><img
					src="images/photo4.jpg" alt="Photographie" />
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