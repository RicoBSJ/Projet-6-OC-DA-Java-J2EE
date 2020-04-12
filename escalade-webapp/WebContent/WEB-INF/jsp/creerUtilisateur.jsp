<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Création d'un utilisateur</title>
        <link type="text/css" rel="stylesheet" href="<c:url value="/include/style.css"/>" />
    </head>
    <body>
        <c:import url="/include/menu.jsp" />
        <div>
            <form method="post" action="<c:url value="/creationUtilisateur"/>" enctype="multipart/form-data">
            	<c:import url="/include/inc_utilisateur_form.jsp" />
            </form>
        </div>
    </body>
</html>