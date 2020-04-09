<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<head>
 <title>User Management Application</title>
</head>
<body>
 <center>
  <h1>User Management</h1>
        <h2>
         <a href="../WEB-INF/jsp/inscription.jsp">Add New User</a>
         &nbsp;&nbsp;&nbsp;
         <a href="../WEB-INF/jsp/listeUtilisateurs.jsp">List All Users</a>

        </h2>
 </center>
    <div align="center">
  		<c:if test="${utilisateur != null}">
   			<form action="update" method="post">
        </c:if>
        <c:if test="${utilisateur == null}">
   			<form action="insert" method="post">
        </c:if>
        <table border="1" cellpadding="5">
            <caption>
             <h2>
              <c:if test="${utilisateur != null}">
               Edit User
              </c:if>
              <c:if test="${utilisateur == null}">
               Add New User
              </c:if>
             </h2>
            </caption>
          <c:if test="${user != null}">
           <input type="hidden" name="id" value="<c:out value='${utilisateur.id}' />" />
          </c:if>
            <tr>
                <th>Nom de l'utilisateur : </th>
                <td>
                 <input type="text" name="name" size="45"
                   value="<c:out value='${utilisateur.nom}' />"
                  />
                </td>
            </tr>
            <tr>
                <th>Prénom de l'utilisateur : </th>
                <td>
                 <input type="text" name="name" size="45"
                   value="<c:out value='${utilisateur.prenom}' />"
                  />
                </td>
            </tr>
            <tr>
                <th>Adresse de l'utilisateur : </th>
                <td>
                 <input type="text" name="name" size="45"
                   value="<c:out value='${utilisateur.adresse}' />"
                  />
                </td>
            </tr>
            <tr>
                <th>Téléphone de l'utilisateur : </th>
                <td>
                 <input type="text" name="name" size="45"
                   value="<c:out value='${utilisateur.telephone}' />"
                  />
                </td>
            </tr>
            <tr>
                <th>Email de l'utilisateur: </th>
                <td>
                 <input type="text" name="email" size="45"
                   value="<c:out value='${utilisateur.email}' />"
                 />
                </td>
            </tr>
            <tr>
                <th>Mot de passe de l'utilisateur: </th>
                <td>
                 <input type="text" name="email" size="45"
                   value="<c:out value='${utilisateur.email}' />"
                 />
                </td>
            </tr>
            <tr>
                <th>Confirmation du mot de passe de l'utilisateur: </th>
                <td>
                 <input type="text" name="email" size="45"
                   value="<c:out value='${utilisateur.email}' />"
                 />
                </td>
            </tr>
            <tr>
             <td colspan="2" align="center">
              <input type="submit" value="Save" />
             </td>
             <p><a href="<c:url value="/accueil"/>">Retour à l'accueil</a></p>
            </tr>
        </table>
        </form>
    </div>
</body>
</html>