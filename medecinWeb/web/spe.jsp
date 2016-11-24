<%-- 
    Document   : med
    Created on : 16 nov. 2016, 11:52:37
    Author     : sio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <table border="1">
            <tr>
                <th>Nom</th>
                <th>Prénom</th>
                <th>Adresse</th>
                <th>Téléphone</th>
                <th>Spécialité</th>
            </tr>

            <c:forEach var="unMed" items="${liste}">
                <tr>
                    <td>${unMed.nom}</td>
                    <td>${unMed.prenom}</td>
                    <td>${unMed.adresse}</td>
                    <td>${unMed.tel}</td>
                    <td>${unMed.spe}</td>
                </tr>
            </c:forEach>

        </table>
    </body>
</html>
