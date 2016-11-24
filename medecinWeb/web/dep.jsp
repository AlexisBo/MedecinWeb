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
        <h2>Liste des départements</h2>
        <form action="control?choix=dep" method="post">
            <select name="dep">
                <c:forEach var="p" items="${listeDeps}">

                    <option value="${p.getNum()}">${p.getNum()}</option>

                </c:forEach>
            </select>
            <button type="submit">Valider</button>
        </form>
        <br>
        
        <h2>Liste des Spécialités</h2>
        <form action="control?choix=spec" method="post">
            <select name="spec">
                <c:forEach var="s" items="${listeSpec}">

                    <option value="${s.getLibelle()}">${s.getLibelle()}</option>

                </c:forEach>
            </select>
            <button type="submit">Valider</button>
        </form>
        <br>
        
        <h2>Liste triée des noms</h2>
        <form action="control?choix=trier" method="post">
            <input type="text" name="prefix" placeholder="Nom">
            <button type="submit">Valider</button>
        </form>
        
        

    </body>
</html>
