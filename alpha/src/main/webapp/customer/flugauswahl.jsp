<%-- 
    Document   : auswahl
    Created on : 13.05.2020, 17:25:09
    Author     : Julia
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@include file="/WEB-INF/jspf/header.jspf" %>

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
                    <option value="${flug.fid}">${flug.datum}</option>
                    </c:forEach>
                </select> &nbsp &nbsp
                <input type="submit" value="Flug buchen"> <br />
            </fieldset>
        </form>
