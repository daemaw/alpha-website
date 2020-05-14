<%-- 
    Document   : nutzer_anlegen
    Created on : 13.05.2020, 18:02:00
    Author     : z004366p
--%>

<%@include file="WEB-INF/jspf/header.jspf" %>
<h2>Hier können sie sich registrieren</h2>
<form action="exnutzer_anlegen" method="POST">
    <table>
        <tr>
            <td><label for="username">Username: </label></td>
            <td><input type="text" name="username" placeholder="Nickname" required/></td>
        </tr>
        <tr>
            <td><label for="vorname">Vorname: </label></td>
            <td><input type="text" name="vorname" placeholder="Max" required/></td>
        </tr>
        <tr>
            <td><label for="Nachname">Nachname: </label></td>
            <td><input type="text" name="nachname" placeholder="Mustermann" required/></td>
        </tr>
        <tr>
            <td><label for="passwort">Passwort: </label></td>
            <td><input type="password" name="passwort" id="passwort" placeholder="Passwort" onkeyup='check();' required/></td>
        </tr>
        <tr>
            <td><label for="passwort_wiederholen">Passwort wiederholen: </label></td>
            <td><input type="password" name="passwort_wiederholen" id="passwort_wiederholen" placeholder="Passwort" onkeyup='check();' required/>&nbsp;<span id='message'></span></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" id="submit" name="submit" value="Registrieren" /></td>
        </tr>
</form>
</body>
<script type="text/javascript">
    var check = function () {
        if (document.getElementById('passwort').value ===
                document.getElementById('passwort_wiederholen').value) {
            document.getElementById('message').style.color = 'green';
            document.getElementById('message').innerHTML = 'Passwörter stimmen überein';
            document.getElementById('submit').disabled = false;
        } else {
            document.getElementById('message').style.color = 'red';
            document.getElementById('message').innerHTML = 'Passwörter stimmen nicht überein';
            document.getElementById('submit').disabled = true;
            
        }
    };
</script>
</html>
