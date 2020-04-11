<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Inscription</title>
        <link type="text/css" rel="stylesheet" href="<c:url value="/include/style.css"/>" />
    </head>
    <body>
    	<c:import url="/include/menu.jsp"></c:import>
        <form method="post" action="inscription">
            <fieldset>
                <legend>Inscription</legend>
                <p>Vous pouvez vous inscrire via ce formulaire.</p>

				<label for="emailUtilisateur">Adresse email <span class="requis">*</span></label>
				<input type="email" id="emailUtilisateur" name="emailUtilisateur" value="<c:out value="${utilisateur.email}"/>" size="30" maxlength="60" />
				<span class="erreur">${form.erreurs[utilisateur.email]}</span>
                <br />

                <label for="motdepasseUtilisateur">Mot de passe <span class="requis">*</span></label>
                <input type="password" id="motdepasseUtilisateur" name="motdepasseUtilisateur" value="" size="20" maxlength="20" />
                <span class="erreur">${form.erreurs['motdepasseUtilisateur']}</span>
                <br />

                <label for="confirmationUtilisateur">Confirmation du mot de passe <span class="requis">*</span></label>
                <input type="password" id="confirmationUtilisateur" name="confirmationUtilisateur" value="" size="20" maxlength="20" />
                <span class="erreur">${form.erreurs['confirmationUtilisateur']}</span>
                <br />

				<label for="nomUtilisateur">Nom d'utilisateur <span class="requis">*</span></label>
				<input type="text" id="nomUtilisateur" name="nomUtilisateur" value="<c:out value="${utilisateur.nom}"/>" size="30" maxlength="30" />
				<span class="erreur">${form.erreurs['nomUtilisateur']}</span>
                <br />
                
				<label for="telephoneUtilisateur">Numéro de téléphone <span class="requis">*</span></label>
				<input type="text" id="telephoneUtilisateur" name="telephoneUtilisateur" value="<c:out value="${utilisateur.telephone}"/>" size="30" maxlength="30" />
				<span class="erreur">${form.erreurs['telephoneUtilisateur']}</span>
                <br />

                <input type="submit" value="Inscription" class="sansLabel" />
                <br />
                
                <p class="${empty erreurs ? 'succes' : 'erreur'}">${resultat}</p>
            </fieldset>
        </form>
        <p><a href="<c:url value="/accueil"/>">Retour à l'accueil</a></p>
    </body>
</html>