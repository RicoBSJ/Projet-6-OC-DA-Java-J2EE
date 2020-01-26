<%@ page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<link rel="stylesheet" href="/css/style.css" />
<style type="text/css">
p {
	width: 350px; /* On a indiqué une largeur (obligatoire) */
	margin: auto;
	/* On peut donc demander à ce que le bloc soit centré avec auto */
	border: 1px solid black;
	text-align: justify;
	padding: 12px;
	margin-bottom: 20px;
	overflow: auto;
	word-wrap: break-word;
}

#conteneur {
	display: flex;
	justify-content: center;
	align-items: center;
}
</style>
<title>Tous les sites de l'escalade</title>
</head>
<body>

	<header>
		<h1 class="conteneur">Les amis de l'escalade</h1>
		<p>Site développé par RicoBSJ</p>
	</header>

	<nav>
		<ol>
			<li><a href="/accueil.jsp">Accueil</a></li>
			<li><a href="/ajouterSite.jsp">Recherche</a></li>
		</ol>
	</nav>

	<section>
		<aside>
			<h1 class="conteneur">Les Têtes Brûlées</h1>
		</aside>

		<article>
			<p>Nom du site</p>
			<p>Localisation</p>
			<p>Pays</p>
			<p>
				<a
					href="https://www.grimper.com/media/020/01/baroud__crop_250x170.jpg">Photo</a>
			</p>
		</article>
	</section>

	<ul>
		<c:forEach var="site" items="${ sites }">
			<li><c:out value="${ site.nomSite }" /></li>
		</c:forEach>
	</ul>

	<footer>
		<p>
			Copyright Les amis de l'escalade - Tous droits réservés<br /> <a
				href="#">Nous contacter !</a>
		</p>
	</footer>

</body>
</html>