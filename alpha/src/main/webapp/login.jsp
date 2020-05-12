<%-- 
    Document   : login
    Created on : 07.05.2020, 14:28:01
    Author     : Eimstoa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@include file="WEB-INF/jspf/header.jspf" %>
        <h1>Welcome to Alpha login</h1>
        <form method="POST" action="exlogin">
            <label for="username">Username: </label>
            <input type="text" name="username" placeholder="JonDoe" /><br />
            <label for="password">Passwort: </label>
            <input type="password" name="passwort" placeholder="******" /><br />
            <span style="color: red;">${errMsg}<br /></span>
            <input type="submit" value="Einloggen" />
        </form>
    </body>
</html>
