<%-- 
    Document   : auswahl
    Created on : 13.05.2020, 17:25:09
    Author     : Julia
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@include file="/WEB-INF/jspf/header.jspf" %>
<link rel="stylesheet" href="/alpha/tablestyle.css" type="text/css">

<br />
<form id="fluege" method="GET" action="fluege">
            <fieldset style="background-color: whitesmoke;"> 
                <legend>Wann möchten Sie fliegen?</legend> <br />
                Datum :  
                <input type="date" id="datum" onclick="Function()">
                &nbsp &nbsp
                Uhrzeit : 
                <select name="zeit">
                    <c:forEach var="flug" items="${flugListe}">
                    <option value="${flug.fid}">${flug.datum}</option>
                    </c:forEach>
                </select> &nbsp &nbsp
                <input type="submit" value="Flug buchen"> <br /> <br /> 
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
</html>
