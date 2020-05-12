<%-- 
    Document   : buchungen
    Created on : 08.05.2020, 12:55:18
    Author     : Eimstoa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Meine Buchungen</title>
    </head>
    <body>
        <h1>Meine Buchungen</h1>
        
        <table border="1">
            <tr>
                <th>Buchungsnummer</th>
                <th>Flugnummer</th>
                <th>Datum</th>
                <th>Abflug</th>
                <th>Ankunft</th>
                <th>Status</th>
                <th></th>
                
            </tr>
            <c:forEach var="buchung" items="${buchungsListe}">
                <tr>
                    <td>${buchung.bid}</td>
                    <td>${buchung.flug.fid}</td>
                    <td>${buchung.datum}</td>
                    <td>${buchung.flug.flugziel.abflug}</td>
                    <td>${buchung.flug.flugziel.ankunft}</td>
                    <td>${buchung.datum}</td>
                    
                    
                    <td><a href="exstornieren?bid=${buchung.bid}">Stornieren</a></td>
                    
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
