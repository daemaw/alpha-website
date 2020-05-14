<%-- 
    Document   : auswahl
    Created on : 13.05.2020, 17:25:09
    Author     : Julia
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@include file="/WEB-INF/jspf/header.jspf" %>

<br />
<form id="fluege" method="GET" action="fluege">
            <fieldset style="background-color: whitesmoke;"> 
                <legend>Wann möchten Sie fliegen?</legend> <br />
                Datum :  
                <input type="date" id="datum">
                &nbsp &nbsp
                Uhrzeit : 
                <select name="zeit">
                    <c:forEach var="flug" items="${flugListe}">
                    <option value="${flug.fid}">${flug.datum}</option>
                    </c:forEach>
                </select> &nbsp &nbsp
                <input type="submit" value="Flug buchen"> <br />
            </fieldset>
        </form>

    <script>
         function gueltigesDatum (datum) {
  //(Schritt 1) Fehlerbehandlung
  if (!datum) return false;
  datum = datum.toString();
 
  //(Schritt 2) Aufspaltung des Datums
  datum = datum.split('.');
  if (datum.length != 3) return false;
 
  //(Schritt 3) Entfernung der fuehrenden Nullen und Anpassung des Monats
  datum[0] = parseInt(datum[0], 10);
  datum[1] = parseInt(datum[1], 10)-1;
 
  //(Schritt 4) Behandlung Jahr nur zweistellig
  if (datum[2].length == 2) datum[2] = '20' + datum[2];
 
  //(Schritt 5) Erzeugung eines neuen Dateobjektes
  var kontrolldatum = new Date(datum[2], datum[1], datum[0]);
 
  //(Schritt 6) Vergleich, ob das eingegebene Datum gleich dem JS-Datum ist
  if (kontrolldatum.getDate() == datum[0] && kontrolldatum.getMonth() == datum[1] && kontrolldatum.getFullYear() == datum[2])
  return true; else return false;
} function gueltigesDatum (datum) {
  //(Schritt 1) Fehlerbehandlung
  if (!datum) return false;
  datum = datum.toString();
 
  //(Schritt 2) Aufspaltung des Datums
  datum = datum.split('.');
  if (datum.length != 3) return false;
 
  //(Schritt 3) Entfernung der fuehrenden Nullen und Anpassung des Monats
  datum[0] = parseInt(datum[0], 10);
  datum[1] = parseInt(datum[1], 10)-1;
 
  //(Schritt 4) Behandlung Jahr nur zweistellig
  if (datum[2].length == 2) datum[2] = '20' + datum[2];
 
  //(Schritt 5) Erzeugung eines neuen Dateobjektes
  var kontrolldatum = new Date(datum[2], datum[1], datum[0]);
 
  //(Schritt 6) Vergleich, ob das eingegebene Datum gleich dem JS-Datum ist
  if (kontrolldatum.getDate() == datum[0] && kontrolldatum.getMonth() == datum[1] && kontrolldatum.getFullYear() == datum[2])
  return true; else return false;
}
    </script
        

</body>
</html>
