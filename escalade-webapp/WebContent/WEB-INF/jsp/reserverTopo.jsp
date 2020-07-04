<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>Demande de réservation de topo</title>
<link type="text/css" rel="stylesheet"
	href="<c:url value="/include/style.css"/>" />
</head>
<body>
	<c:import url="/include/menu.jsp"></c:import>
	<form action="reserverTopo" method="post">
		<fieldset>
			<legend>Reserver un topo</legend>
			<p>Vous pouvez faire une demande de réservation de topo via ce formulaire.</p>
			<br>

			<input type="hidden" value="${topo.id}" name="idTopo">
			<input type="hidden" value="${topo.utilisateur.id}" name="idUser">
			<label for="destinataire">Propriétaire du topo <span class="requis">*</span></label>
			<input name="destinataire" type="text" value="${message.destinataire}"><br><br>
			<span class="erreur">${form.erreurs['destinataire']}</span>
			
			<label for="emetteur">Emetteur de la demande de réservation <span class="requis">*</span></label>
			<input name="emetteur" type="text" value="${message.emetteur}"><br><br>
			<span class="erreur">${form.erreurs['emetteur']}</span>
			
			<label for="topo">Topo <span class="requis">*</span></label>
			<input name="topo" type="text" value="${message.topo}"><br><br>
			<span class="erreur">${form.erreurs['topo']}</span>
			
			<label for="message">Message <span class="requis">*</span></label>
			<textarea name="message">${message.message}</textarea><br>
			<span class="erreur">${form.erreurs['message']}</span>

			<input type="submit" value="Valider" /> <input type="reset"
				value="Remettre à zéro" />

			<p class="${empty form.erreurs ? 'succes' : 'erreur'}">${form.resultat}</p>
		</fieldset>
	</form>
	<p>
		<a href="<c:url value="/accueil"/>">Retour à l'accueil</a>
	</p>
</body>
</html>