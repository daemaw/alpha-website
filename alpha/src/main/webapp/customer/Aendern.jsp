<%-- 
    Document   : Aendern
    Created on : 14.05.2020, 20:03:00
    Author     : Julia
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@include file="/WEB-INF/jspf/header.jspf" %>

<br />
<form id="fluege" method="GET" action="fluege">
            <fieldset style="background-color: whitesmoke;"> 
                <legend>Wann möchten Sie fliegen?</legend> <br />
                Datum :  
                <input type="date" value="${datum}" id="datum">
                &nbsp &nbsp
                Uhrzeit : 
                <select name="zeit">
                    <c:forEach var="flug" items="${flugListe}">
                    <option id="${flug.fid}" value="${flug.fid}">${flug.datum}</option>
                    </c:forEach>
                </select> &nbsp &nbsp
                <input type="submit" value="Flug aktualisieren"> <br />
                <table style="width: 300px;">
                    <tr>
                        <th>Zeit</th>
                        <th>Preis</th>
                    </tr>
                    <c:forEach var="flug" items="${flugListe}">
                    <tr>
                        <td>${flug.datum}</td>
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

