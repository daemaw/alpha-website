<%-- 
    Document   : landingpage
    Created on : 08.05.2020, 11:23:18
    Author     : z0040scb
--%>

<%@include file="/WEB-INF/jspf/header.jspf" %>

        <img src="/alpha/pic/Design.jpg" height="auto"width="80%" style="display:block;margin-left:auto;margin-right:auto;">
        
        <form method="GET" action="flugziel">
            <fieldset style="background-color: whitesmoke;"> 
                <legend>W�hlen Sie Ihren Flug</legend> <br />
                Von :  
                <select name="abflug">
                    <option value="muc" id="muc">M�nchen</option>
                    <option value="jfk">John F. Kennedy</option>
                    <option value="txl">Berlin - Tegel</option>
                    <option value="cdg">Paris Charles de Gaulle</option>
                </select> &nbsp &nbsp
                Nach : 
                <select name="ankunft">
                    <option value="muc" id="muc2">M�nchen</option>
                    <option value="jfk">John F. Kennedy</option>
                    <option value="txl">Berlin - Tegel</option>
                    <option value="cdg">Paris Charles de Gaulle</option>
                </select> &nbsp &nbsp
                <input type="submit" value="Weiter"> <br />
            </fieldset>
        </form> <br /> <br />
        <form>
            Die Verbreitung des Coronavirus stellt uns alle vor gr��te Herausforderungen. Wirtschaftliche, aber vor allem auch menschliche. 
            Doch gemeinsam werden wir auch diese schwierige Zeit meistern. 
            <br /> <br />
            Wir freuen uns jetzt schon darauf, Sie wieder an Bord begr��en zu d�rfen. Wenn es endlich wieder hei�t:
            "Say yes to the world!".
            <br /> <br />
            Bleiben Sie gesund.
        </form> <br /> <br />
        <form style="background-color:white">
            Warum Sie mit Alpha Airlines fliegen sollten?
            <br /> <br />
            <fieldset style="float:left;display:inline-block;color:white;">Keine versteckten Kosten</fieldset>
            <fieldset style="float:left;display:inline-block;color:white;">Mehr Komfort zum besseren Preis</fieldset> 
            <fieldset style="float:left;display:inline-block;color:white;">Regelm��ige Updates zu Ihrer Reise</fieldset> 
            <fieldset style="float:left;display:inline-block;color:white;">Flexibel dank Bedenkzeit</fieldset>
        </form> <br /> <br />
        <form>
            
        </form>
        
        <script>
            function Function() {
                var muc = document.getElementById("muc");
                var muc2 = document.getElementById("muc2");
                
                if (muc.checked == true) {muc2.style.display = "block";} else {muc2.style.display = "none";}
            }
        </script>
        
    </body>
 
</html>

