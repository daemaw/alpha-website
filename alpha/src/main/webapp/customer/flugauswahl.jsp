<%-- 
    Document   : auswahl
    Created on : 13.05.2020, 17:25:09
    Author     : Julia
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@include file="/WEB-INF/jspf/header.jspf" %>
<link rel="stylesheet" href="/alpha/tablestyle.css" type="text/css">

<br />
<form id="fluege" method="POST" action="/alpha/customer/eintragen">
            <fieldset style="background-color: whitesmoke;"> 
                <legend>Wann möchten Sie fliegen?</legend> <br />
                Datum :  
                <input type="date" name="datum">
                &nbsp &nbsp
                Uhrzeit : 
                <select name="fidu">
                    <c:forEach var="flug" items="${flugListe}">
                    <option value="${flug.fid}">${flug.zeit}</option>
                    </c:forEach>
                </select> &nbsp &nbsp
                <input type="submit" value="Flug buchen"> <br /> <br /> 
                <table style="width: 300px;">
                    <tr>
                        <th>Zeit</th>
                        <th>Preis</th>
                        <th>Flugdauer</th>
                    </tr>
                    <c:forEach var="flug" items="${flugListe}">
                    <tr>
                        <td>${flug.zeit}</td>
                        <td>${flug.preis}</td>
                        <td>${flug.flugdauer}</td>
                    </tr>
                    </c:forEach>
                </table>
                    
            </fieldset>
        </form>


    </body>
</html>
