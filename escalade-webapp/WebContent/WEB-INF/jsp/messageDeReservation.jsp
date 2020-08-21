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
<title>Demande de réservation de topo</title>
</head>
<body>
	<div class="container">
	<c:import url="/include/menu.jsp"></c:import>
	<form action="messageDeReservation" method="post">
		<fieldset>
			<legend>Message de réservation d'un topo</legend>
			<p>Vous pouvez faire une demande de réservation de topo via ce formulaire.</p>
			<br>

			<input type="hidden" value="${topo.id}" name="idDispo">

			<label for="message">Message <span class="requis">*</span></label>
			<textarea name="message"></textarea>
			<br><br>
			
			<span class="erreur">${form.erreurs['message']}</span>
			<input type="submit" value="Valider" />
			<input type="reset" value="Remettre à zéro" />
			<p class="${empty form.erreurs ? 'succes' : 'erreur'}">${form.resultat}</p>
		</fieldset>
	</form>
	<p>
		<a href="<c:url value="/afficherToposDisponibles"/>">Retour à l'affichage des topos disponibles</a> <br>
		<br> <a href="<c:url value="/accueil"/>">Retour à l'accueil</a>
	</p>
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
	</div>
</body>
</html>