<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<label for="nom">Nom <span class="requis">*</span></label>
<input type="text" id="nom" name="nom" value="<c:out value="${utilisateur.nom}"/>" size="30" maxlength="30" />
<span class="erreur">${erreurs['nom']}</span>
<br />

<label for="prenom">Prénom <span class="requis">*</span></label>
<input type="text" id="prenom" name="prenom" value="<c:out value="${utilisateur.prenom}"/>" size="30" maxlength="30" />
<span class="erreur">${erreurs['prenom']}</span>
<br />

<label for="telephone">Numéro de téléphone <span class="requis">*</span></label>
<input type="text" id="telephone" name="telephone" value="<c:out value="${utilisateur.telephone}"/>" size="30" maxlength="30" />
<span class="erreur">${erreurs['telephone']}</span>
<br />

<label for="email">Adresse email <span class="requis">*</span></label>
<input type="email" id="email" name="email" value="<c:out value="${utilisateur.email}"/>" size="30" maxlength="60" />
<span class="erreur">${erreurs['email']}</span>
<br />