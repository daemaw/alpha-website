<%-- 
    Document   : statistik
    Created on : 08.05.2020, 13:24:05
    Author     : z0041r3p
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link rel="stylesheet" href="/alpha/tablestyle.css" type="text/css">
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Statistik</title>
    </head>
    <body>
        <h1 style="font-family:'Arial'">Statistik</h1>
        <table border="1">
            <tr>
                <th>Anzahl Stornierungen</th>
                <th>Anzahl bereits geflogen</th>
                <th>Anzahl registrierter User</th>
                <th>Anzahl gebuchter Flüge</th>
                <th>Umsatz</th>
            </tr>
            <tr>
                <td>${stat.anz_storn}</td>
                <td>${stat.anz_geflog}</td>
                <td>${stat.anz_user}</td>
                <td>${stat.anz_aktiv}</td>
                <td>${stat.umsatz}</td>
            </tr>
        </table>
    </body>
</html>
