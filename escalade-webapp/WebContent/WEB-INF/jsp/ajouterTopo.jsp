<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
<link type="text/css" rel="stylesheet"
	href="<c:url value="/include/style.css" />" />
        <title>Ajouter un topo</title>
    </head>
    <body>
    	<div class="container">
    	<c:import url="/include/menu.jsp"></c:import>
        <form method="post" action="ajouterTopo">
            <fieldset>
                <c:if test="${ !empty sessionScope.sessionUtilisateur }">
                <legend>Ajouter un topo</legend>
                <p>Vous pouvez vous ajouter un topo via ce formulaire.</p>
				<br>
				<input type="hidden" value="${topo.id}" name="id">
				<label for="nom">Nom de topo <span class="requis">*</span></label>
				<input type="text" id="nom" name="nom" value="<c:out value="${topo.nom}"/>" size="20" maxlength="20" />
				<span class="erreur">${form.erreurs['nom']}</span>
                <br><br>
                <label for="description">Description du topo <span class="requis">*</span></label>
				<textarea name="description">${topo.description}</textarea>
				<span class="erreur">${form.erreurs['description']}</span>
				<br><br>
                <label for="lieu">Lieu du topo <span class="requis">*</span></label>
				<input type="text" id="lieu" name="lieu" value="<c:out value="${topo.lieu}"/>" size="20" maxlength="20" />
				<span class="erreur">${form.erreurs['lieu']}</span>
                <br><br>
                <label for="dateParution">Date de parution du topo <span class="requis">*</span></label>
				<input type="date" id="dateParution" name="dateParution" value="<c:out value="${topo.dateParution}"/>" size="20" maxlength="20" />
				<span class="erreur">${form.erreurs['dateParution']}</span>
                <br><br>
                </c:if>
                
                <c:if test="${ !empty sessionScope.sessionUtilisateur }">
                   <label for="choixNouveauSite">Nouveau site ? <span class="requis">*</span></label>
                   <input type="radio" id="choixNouveauSite" name="choixNouveauSite" value="nouveauSite" checked /> Oui
                   <input type="radio" id="choixNouveauSite" name="choixNouveauSite" value="ancienSite" /> Non
                   <br/><br />
                </c:if>
                <c:set var="site" value="${ sites }" scope="request" />
                   <div id="nouveauSite">
                      <a href="<c:url value="/creationSite" />">Création site</a>
                   </div>
                <c:if test="${ !empty sessionScope.sessionUtilisateur }">
                    <div id="ancienSite">
                        <select name="idSite" id="idSite">
                            <option value="">Choisissez un site...</option>
                            	<c:forEach items="${ sites }" var="site">
                            		<option value="${ site.id }">${ site.nom } ${ site.pays }</option>
                            	</c:forEach>
                        </select>
                    </div>
                </c:if>
                </fieldset>
                <input type="submit" value="Valider"  />
                <input type="reset" value="Remettre à zéro" /> <br />
            </form>
            <p><a href="<c:url value="/afficherToposUtilisateur"/>">Retour aux topos de l'utilisateur</a></p>
            <p><a href="<c:url value="/accueil"/>">Retour à l'accueil</a></p>
        
        <%-- Inclusion de la bibliothèque jQuery. Vous trouverez des cours sur JavaScript et jQuery aux adresses suivantes :
               - http://www.siteduzero.com/tutoriel-3-309961-dynamisez-vos-sites-web-avec-javascript.html 
               - http://www.siteduzero.com/tutoriel-3-659477-un-site-web-dynamique-avec-jquery.html 
               
             Si vous ne souhaitez pas télécharger et ajouter jQuery à votre projet, vous pouvez utiliser la version fournie directement en ligne par Google :
             <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.8.0/jquery.min.js"></script> 
        --%>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.8.0/jquery.min.js"></script>
        
        <%-- Petite fonction jQuery permettant le remplacement de la première partie du formulaire par la liste déroulante, au clic sur le bouton radio. --%>
        <script>
        	jQuery(document).ready(function(){
        		/* 1 - Au lancement de la page, on cache le bloc d'éléments du formulaire correspondant aux sites existants */
        		$("div#ancienSite").hide();
        		/* 2 - Au clic sur un des deux boutons radio "choixNouveauClient", on affiche le bloc d'éléments correspondant (nouveau ou ancien site) */
                jQuery('input[name=choixNouveauSite]:radio').click(function(){
                	$("div#nouveauSite").hide();
                	$("div#ancienSite").hide();
                    var divId = jQuery(this).val();
                    $("div#"+divId).show();
                });
            });
        </script>
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