<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>Demande de r�servation de topo</title>
<link type="text/css" rel="stylesheet"
	href="<c:url value="/include/style.css"/>" />
</head>
<body>
	<c:import url="/include/menu.jsp"></c:import>
	<form action="messageDeReservation" method="post">
		<fieldset>
			<legend>Message de r�servation d'un topo</legend>
			<p>Vous pouvez faire une demande de r�servation de topo via ce formulaire.</p>
			<br>

			<input type="hidden" value="${topo.id}" name="idDispo">

			<label for="message">Message <span class="requis">*</span></label>
			<textarea name="message"></textarea>
			<br><br>
			
			<span class="erreur">${form.erreurs['message']}</span>
			<input type="submit" value="Valider" />
			<input type="reset" value="Remettre � z�ro" />
			<p class="${empty form.erreurs ? 'succes' : 'erreur'}">${form.resultat}</p>
		</fieldset>
	</form>
	<p>
		<a href="<c:url value="/afficherToposDisponibles"/>">Retour � l'affichage des topos disponibles</a> <br>
		<br> <a href="<c:url value="/accueil"/>">Retour � l'accueil</a>
	</p>
</body>
</html>