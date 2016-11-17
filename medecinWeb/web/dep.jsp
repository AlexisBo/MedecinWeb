<%-- 
    Document   : dep
    Created on : 16 nov. 2016, 11:52:27
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
        <h1>Liste des départements</h1>
        <form action="control" method="get">
            <select name="choix">
                <c:forEach var="p" items="${liste}">

                    <option>${p.value.num}</option>

                </c:forEach>
            </select>
            <button type="submit">Valider</button>
        </form>
    </body>
</html>
