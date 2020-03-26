<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<label for="nomUtilisateur">Nom <span class="requis">*</span></label>
<input type="text" id="nomUtilisateur" name="nomUtilisateur" value="<c:out value="${utilisateur.nom}"/>" size="30" maxlength="30" />
<span class="erreur">${form.erreurs['nomUtilisateur']}</span>
<br />

<label for="prenomUtilisateur">Prénom </label>
<input type="text" id="prenomUtilisateur" name="prenomUtilisateur" value="<c:out value="${utilisateur.prenom}"/>" size="30" maxlength="30" />
<span class="erreur">${form.erreurs['prenomUtilisateur']}</span>
<br />

<label for="adresseUtilisateur">Adresse de livraison <span class="requis">*</span></label>
<input type="text" id="adresseUtilisateur" name="adresseUtilisateur" value="<c:out value="${utilisateur.adresse}"/>" size="30" maxlength="60" />
<span class="erreur">${form.erreurs['adresseUtilisateur']}</span>
<br />

<label for="telephoneUtilisateur">Numéro de téléphone <span class="requis">*</span></label>
<input type="text" id="telephoneUtilisateur" name="telephoneUtilisateur" value="<c:out value="${utilisateur.telephone}"/>" size="30" maxlength="30" />
<span class="erreur">${form.erreurs['telephoneUtilisateur']}</span>
<br />

<label for="emailUtilisateur">Adresse email</label>
<input type="email" id="emailUtilisateur" name="emailUtilisateur" value="<c:out value="${utilisateur.email}"/>" size="30" maxlength="60" />
<span class="erreur">${form.erreurs['emailUtilisateur']}</span>
<br />