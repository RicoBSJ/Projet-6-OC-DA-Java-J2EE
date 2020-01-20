<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>Lister sites</title>
</head>
<body>

	<ul>
		<c:forEach var="site" items="${ sites }">
			<li><c:out value="${ site.nomSite }" /></li>
		</c:forEach>
	</ul>

</body>
</html>