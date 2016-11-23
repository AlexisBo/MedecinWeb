<%-- 
    Document   : medTrier
    Created on : 17 nov. 2016, 15:54:42
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
            <c:forEach var="MedTrier" items="${liste}">
                <tr>
                    <td>${MedTrier.nom}</td>
                    <td>${MedTrier.prenom}</td>
                    <td>${MedTrier.adresse}</td>
                    <td>${MedTrier.tel}</td>
                    <td>${MedTrier.spe}</td>
                </tr>
            </c:forEach>
    </body>
</html>
