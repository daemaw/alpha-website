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
            <table>
                <tr>
                    <td><label for="username">Username: </label></td>
                    <td><input type="text" name="username" placeholder="JonDoe" /></td>
                </tr>
                <tr>
                    <td><label for="password">Passwort: </label></td>
                    <td><input type="password" name="passwort" placeholder="******" /></td>
                </tr>
                <tr>
                    <td colspan="2"><span style="color: red;">${errMsg}${param.msg}</span><span style="color: green;">${succMsg}</span></td>
                </tr>
                <tr>
                    <td colspan="2"><input type="submit" value="Einloggen" /></td>
                </tr>
            </table>
        </form> <br /> <br />
        
        Sie sind noch nicht registriert?
            <a href="nutzer_anlegen.jsp">Hier als Nutzer registrieren</a>
    </body>
</html>
