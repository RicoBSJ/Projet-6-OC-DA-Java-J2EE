<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

            <fieldset>
                <legend>Inscription</legend>
                <p>Vous pouvez vous inscrire via ce formulaire.</p>

				<label for="emailUtilisateur">Adresse email <span class="requis">*</span></label>
				<input type="email" id="emailUtilisateur" name="emailUtilisateur" value="<c:out value="${utilisateur.email}"/>" size="30" maxlength="60" />
				<span class="erreur">${form.erreurs['emailUtilisateur']}</span>
                <br />
                
				<label for="prenomUtilisateur">Prénom d'utilisateur <span class="requis">*</span></label>
				<input type="text" id="prenomUtilisateur" name="prenomUtilisateur" value="<c:out value="${utilisateur.prenom}"/>" size="30" maxlength="30" />
				<span class="erreur">${form.erreurs['prenomUtilisateur']}</span>
                <br />
                
                <label for="nomUtilisateur">Nom d'utilisateur <span class="requis">*</span></label>
				<input type="text" id="nomUtilisateur" name="nomUtilisateur" value="<c:out value="${utilisateur.nom}"/>" size="30" maxlength="30" />
				<span class="erreur">${form.erreurs['nomUtilisateur']}</span>
                <br />
				
				<label for="telephoneUtilisateur">Numéro de téléphone <span class="requis">*</span></label>
				<input type="text" id="telephoneUtilisateur" name="telephoneUtilisateur" value="<c:out value="${utilisateur.telephone}"/>" size="30" maxlength="30" />
				<span class="erreur">${form.erreurs['telephoneUtilisateur']}</span>
                <br />
                
                <label for="adresseUtilisateur">Adresse <span class="requis">*</span></label>
				<input type="text" id="adresseUtilisateur" name="adresseUtilisateur" value="<c:out value="${utilisateur.adresse}"/>" size="30" maxlength="30" />
				<span class="erreur">${form.erreurs['adresseUtilisateur']}</span>
                <br />

                <p class="info">${ form.resultat }</p>
                <input type="submit" value="Valider"  />
                <input type="reset" value="Remettre à zéro" /> <br />
            </fieldset>