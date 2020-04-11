<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>Escalade-Webapp</title>
</head>
<body>
	<c:import url="/include/menu.jsp"></c:import>
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