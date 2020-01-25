<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<link rel="stylesheet" href="style.css" />
<style type="text/css">
h1 {
	color: red;
}

body {
	background-image:
		url("https://c.pxhere.com/photos/ca/4c/photo-80231.jpg!d");
	background-repeat: no-repeat;
/* 	background-position: 100px 150px; */
}
</style>
<title>Premiers tests du CSS</title>
</head>
<body>

	<h1>Bonjour et bienvenue sur mon site !</h1>
	<br />
	<p>
		Ceci est mon premier test alors <em>soyez indulgents</em> s'il vous
		plaît, j'apprends petit à petit comment cela marche.
	</p>
	<ol>
		<li>Fraises</li>
		<li>Framboises</li>
		<li>Cerises</li>
	</ol>
	<p>
		Bonjour. Souhaitez-vous visiter <a href="https://openclassrooms.com"
			title="Vous ne le regretterez pas !" target="_blank">OpenClassrooms</a>
		?
	</p>
	<p>
		<a href="mailto:votrenom@bidule.com">Envoyez-moi un e-mail !</a>
	</p>
	<p>
		<a href="monfichier.zip">Télécharger le fichier</a>
	</p>
	<p>
		Page suivante <a href="detailSite.java">la page 1</a> ?
	</p>
	<ul>
		<c:forEach var="site" items="${ sites }">
			<li><c:out value="${ site.nomSite }" /></li>
		</c:forEach>
	</ul>

	<p>
		Voici une photo que j'ai prise lors de mes dernières vacances à la
		montagne :<br />
		<!-- 		<img src="https://c.pxhere.com/photos/ca/4c/photo-80231.jpg!d" alt="Photo de montagne" /> -->
	</p>

</body>
</html>