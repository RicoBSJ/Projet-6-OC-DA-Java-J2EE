<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>Escalade-Webapp</title>
</head>
<body>
	<form method="post" action="ajouterSite">
		<p>
			<label for="nomSite">Nom du site : </label> <input type="text"
				name="nomSite" id="nomSite" />
		</p>

		<input type="submit" name="enregistrerSite" id="enregistrerSite" />

		<ul>
			<c:forEach var="site" items="${ sites }">
				<li><c:out value="${ site.nomSite }" /></li>
			</c:forEach>
		</ul>
	</form>
</body>
</html>