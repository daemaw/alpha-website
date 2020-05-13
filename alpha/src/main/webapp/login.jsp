<%-- 
    Document   : login
    Created on : 07.05.2020, 14:28:01
    Author     : Eimstoa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@include file="WEB-INF/jspf/header.jspf" %>
        <h2>Welcome to Alpha login</h2>
        <form method="POST" action="exlogin"><br />
            <label for="username">Username: </label>
            <input type="text" name="username" placeholder="JonDoe" /><br /><br />
            <label for="password">Passwort: </label>
            <input type="password" name="passwort" placeholder="******" /><br />
            <span style="color: red;">${errMsg}${param.msg}<br /></span>
            <input type="submit" value="Einloggen" />
        </form>
    </body>
</html>
