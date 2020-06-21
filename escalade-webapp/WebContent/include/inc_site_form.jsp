<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

            <fieldset>
                <legend>Inscription</legend>
                <p>Vous pouvez vous créer un site via ce formulaire.</p>
                
				<label for="nomSite">Nom du site <span class="requis">*</span></label>
				<input type="text" id="nomSite" name="nomSite" value="<c:out value="${utilisateur.nom}"/>" size="30" maxlength="30" />
				<span class="erreur">${form.erreurs['nomSite']}</span>
                <br />
				
				<label for="paysSite">Pays du site <span class="requis">*</span></label>
				<input type="text" id="paysSite" name="paysSite" value="<c:out value="${utilisateur.pays}"/>" size="30" maxlength="30" />
				<span class="erreur">${form.erreurs['paysSite']}</span>
                <br />
                
                <label for="regionSite">Région du site <span class="requis">*</span></label>
				<input type="text" id="regionSite" name="regionSite" value="<c:out value="${utilisateur.region}"/>" size="30" maxlength="30" />
				<span class="erreur">${form.erreurs['regionSite']}</span>
                <br />
				
				<label for="descriptionSite">Description du site <span class="requis">*</span></label>
				<input type="text" id="descriptionSite" name="descriptionSite" value="<c:out value="${utilisateur.description}"/>" size="30" maxlength="30" />
				<span class="erreur">${form.erreurs['descriptionSite']}</span>
                <br />
                
				<label for="cotationSite">Cotation du site <span class="requis">*</span></label>
				<input type="text" id="cotationSite" name="cotationSite" value="<c:out value="${utilisateur.cotation}"/>" size="30" maxlength="60" />
				<span class="erreur">${form.erreurs['cotationSite']}</span>
                <br />
                
                <label for="hauteurSite">Hauteur du site <span class="requis">*</span></label>
				<input type="text" id="hauteurSite" name="hauteurSite" value="<c:out value="${utilisateur.hauteur}"/>" size="30" maxlength="60" />
				<span class="erreur">${form.erreurs['hauteurSite']}</span>
                <br />
                
                <label for="orientationSite">Orientation du site <span class="requis">*</span></label>
				<input type="text" id="orientationSite" name="orientationSite" value="<c:out value="${utilisateur.orientation}"/>" size="30" maxlength="60" />
				<span class="erreur">${form.erreurs['orientationSite']}</span>
                <br />

                <input type="submit" value="Valider"  />
                <input type="reset" value="Remettre à zéro" /> <br />
                
                <p class="${empty form.erreurs ? 'succes' : 'erreur'}">${form.resultat}</p>
            </fieldset>