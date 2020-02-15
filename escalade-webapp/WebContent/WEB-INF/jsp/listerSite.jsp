<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>Escalade-Webapp</title>
</head>
<body>
	<form method="post" action="ajouterSite">

		<ul>
			<c:forEach var="site" items="${ sites }">
				<li><c:out value="${ site.nomSite }" /></li>
			</c:forEach>
		</ul>
	</form>
</body>
</html>