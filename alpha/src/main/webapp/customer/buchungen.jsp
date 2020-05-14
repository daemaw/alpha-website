<%-- 
    Document   : buchungen
    Created on : 08.05.2020, 12:55:18
    Author     : Eimstoa
--%>
<%@include file="/WEB-INF/jspf/header.jspf" %>
<link rel="stylesheet" href="/alpha/tablestyle.css" type="text/css">


        <h2>Meine Buchungen</h2>
        
        <table border="1">
            <tr>
                <th>Buchungsnummer</th>
                <th>Flugnummer</th>
                <th>Datum</th>
                <th>Abflug</th>
                <th>Ankunft</th>
                <th>Uhrzeit</th>
                <th>Flugdauer</th>
                <th>Status</th>
                <th></th>
                <th></th>
                
            </tr>
            <c:forEach var="buchung" items="${buchungsListe}">
                <tr>
                    <td>${buchung.bid}</td>
                    <td>${buchung.flug.fid}</td>
                    <td>${buchung.datum}</td>
                    <td>${buchung.flug.flugziel.abflug}</td>
                    <td>${buchung.flug.flugziel.ankunft}</td>
                    <td>${buchung.flug.zeit}</td>
                    <td>${buchung.flug.flugdauer}</td>
                    <td>${buchung.status.status}</td>
                    <td>
                    <c:if test="${buchung.status.sid == 1}">
                        <a href="exstornieren?bid=${buchung.bid}">Stornieren</a>
                    </c:if>
                    </td>
                    <td>
                    <c:if test="${buchung.status.bid == 1}">
                        <a href="/customer/exprepareaendern">Ändern</a>
                    </c:if>
                    </td>
                </tr>
            </c:forEach>
                
                
        </table>
    </body>
</html>
