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
	<div class="container" scope="session">

		<section>
		<div class="row">
					<c:forEach var="site" items="${ sites }">
					<div align="center">
					<div class="col-4">
							<div class="localisationStationListe">
								<h3 class="nomStationListe">
									<a href="<c:url value="" />">${ site.nom }</a>
								</h3>
								<div class="col">
								<div class="massifListe">${ site.pays }</div>
								<div class="massifListe">${ site.region }</div>
								</div>
							</div>
							<div align="center">
							<div class="col-4">
							<div class="thumbs-stations">
								<a href="<c:url value="/detailsSite?id=${site.id}" />">
								<img src="${site.photos[0].cheminPhoto}" alt="Site" title="Détails du site" width="30" height="200"  />
								</a>
							</div>
							</div>
							</div>
							<div align="center">
							<div class="col-4">
							<div class="results-right">
								<div class="infosStations">
								<span class="value"><span>${ site.secteurs[0].description } </span> secteurs</span>
								<span class="value"><span>${ site.voies[0].description }</span> voies</span>
								<span class="value"><span>${ site.longueurs[0].description }</span> longueurs</span>
								</div>
							</div><br>
							</div>
							</div>
					</div>
					</div>
					</c:forEach>
		</div>
		</section>

			<div class="row">
			<h1>À propos des Amis de l'Escalade</h1>
			</div>
			<div class="row">
			<p id="photo_du_site">
				<img src="<c:url value="/images/shutterstock_171542741-711x392.jpg" />"
					alt="Photo du site" />
			</p>
			</div>
			<div class="row">
			<p>Avec l’objectif de fédérer les licenciés, l’association “Les
				amis de l’escalade” souhaite développer sa présence en ligne. À ce
				titre, plusieurs axes d’amélioration ont été identifiés dont la
				création de ce site communautaire.</p>
			<p>Ce site aura pour but la mise en relation et le partage
				d’informations. Il permettra de donner de la visibilité́ à
				l’association afin d’encourager des grimpeurs indépendants à y
				adhérer.</p>
			</div>

		<footer>
		<div align="center">
		<div class="row">
			<div id="tweet">
				<h1>Ma Home GitHub</h1>
				<div align="left">
					<ul>
						<li><a href="<c:url value="https://github.com/RicoBSJ" />">Rico BSJ</a></li>
					</ul>
				</div>
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
				<h1>Les sites de références</h1>
				<div id="listes_sites" align="left">
					<ul>
						<li><a href="<c:url value="https://www.grimper.com/site-escalade-sites" />">Le site Grimper</a></li>
						<li><a href="<c:url value="https://www.vertical-magazine.com/" />">Vertical magazine</a></li>
						<li><a href="<c:url value="https://www.montagnes-magazine.com/" />">Montagne magazine</a></li>
						
					</ul>
					<ul>
						<li><a href="<c:url value="https://www.bigbike-magazine.com/" />">Big bike magazine</a></li>
						<li><a href="<c:url value="https://www.trekmag.com/" />">Trek magazine</a></li>
						<li><a href="<c:url value="https://27crags.com/" />">27 Crags</a></li>
					</ul>
				</div>
			</div>
			</div>
			</div>
		</footer>
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