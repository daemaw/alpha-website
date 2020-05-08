<%-- 
    Document   : landingpage
    Created on : 08.05.2020, 11:23:18
    Author     : z0040scb
--%>

<%@include file="WEB-INF/jspf/header.jspf" %>

        <form method="GET" action="flugziel" style="background-color: whitesmoke">
            <fieldset> 
                <legend>Wählen Sie Ihren Flug</legend> <br />
                Von :  
                <select name="abflug">
                    <option value="muc">MUC</option>
                    <option value="jfk">JFK</option>
                    <option value="txl">TXL</option>
                    <option value="cdg">CDG</option>
                </select> &nbsp &nbsp
                Nach : 
                <select name="ankunft">
                    <option value="muc">MUC</option>
                    <option value="jfk">JFK</option>
                    <option value="txl">TXL</option>
                    <option value="cdg">CDG</option>
                </select> &nbsp &nbsp
                <input type="submit" value="Weiter"> <br />
            </fieldset>
        </form>
    </body>
</html>

