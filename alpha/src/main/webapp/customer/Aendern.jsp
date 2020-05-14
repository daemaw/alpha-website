<%-- 
    Document   : Aendern
    Created on : 14.05.2020, 20:03:00
    Author     : Julia
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@include file="/WEB-INF/jspf/header.jspf" %>
<link rel="stylesheet" href="/alpha/tablestyle.css" type="text/css">

<br />
<form id="fluege" method="GET" action="exaenderneinf">
            <fieldset style="background-color: whitesmoke;"> 
                <legend>Wann möchten Sie fliegen?</legend> <br />
                Datum :  
                <input type="date" value="${datum}" id="datum">
                &nbsp &nbsp
                Uhrzeit : 
                <select name="zeit">
                    <c:forEach var="flug" items="${flugListe}">
                    <option id="${flug.fid}" value="${flug.fid}">${flug.zeit}</option>
                    </c:forEach>
                </select> &nbsp &nbsp
                <input hidden name="bid" value="${bid}">
                <input type="submit" value="Flug aktualisieren"> <br />
                <table style="width: 300px;">
                    <tr>
                        <th>Zeit</th>
                        <th>Preis</th>
                    </tr>
                    <c:forEach var="flug" items="${flugListe}">
                    <tr>
                        <td>${flug.zeit}</td>
                        <td>${flug.preis}</td>
                    </tr>
                    </c:forEach>
                </table>
            </fieldset>
        </form>
       
    </body>
    <script type="text/javascript">
        document.getElementById('${fid}').selected;
    </script>
</html>

