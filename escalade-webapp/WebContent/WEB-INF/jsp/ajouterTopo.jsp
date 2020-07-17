<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Ajouter un topo</title>
        <link type="text/css" rel="stylesheet" href="<c:url value="/include/style.css"/>" />
    </head>
    <body>
    	<c:import url="/include/menu.jsp"></c:import>
    	<div>
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
        </div>
        
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
    </body>
</html>