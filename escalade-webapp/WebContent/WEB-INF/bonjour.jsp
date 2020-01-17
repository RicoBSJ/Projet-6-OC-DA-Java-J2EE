<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>Escalade-Webapp</title>
</head>
<body>
	<form method="post" action="bonjour">
		<p>
			<label for="nomSite">Nom du site : </label> <input type="text"
				name="nomSite" id="nomSite" />
		</p>
		<p>
			<label for="descripSite">Description du site : </label> <input
				type="text" name="descriptSite" id="descriptSite" />
		</p>
		<p>
			<label for="cotationSite">Cotation du site : </label> <input
				type="text" name="cotationSite" id="cotationSite" />
		</p>

		<input type="submit" />
		
	<ul>
		<c:forEach var="site" items="${ sites }">
			<li>
			<c:out value="${ site.nomSite }" />
			</li>
			<li>
			<c:out value="${ site.descripSite }" />
			</li>
			<li>
			<c:out value="${ site.cotationSite }" />
			</li>
		</c:forEach>
	</ul>
	</form>


</body>
</html>