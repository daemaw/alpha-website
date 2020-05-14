<%-- 
    Document   : landingpage
    Created on : 08.05.2020, 11:23:18
    Author     : z0040scb
--%>

<%@include file="/WEB-INF/jspf/header.jspf" %>

        <img src="/alpha/pic/787-8.png" height="auto"width="80%" style="display:block;margin-left:auto;margin-right:auto;">
        <img src="/alpha/pic/wolkenCut.jpg" height="auto"width="100%" style="display:block;margin-left:auto;margin-right:auto;">
        
        <br /> <br />
        
        <form id="buchung" method="GET" action="/alpha/customer/flugauswahl">
            <fieldset style="background-color: whitesmoke;"> 
                <legend>W�hlen Sie Ihren Flug</legend> <br />
                Von :  
                <select id="abflug" name="abflug" onchange="changed(this)">
                </select> &nbsp &nbsp
                Nach : 
                <select id="ankunft" name="ankunft">
                </select> &nbsp &nbsp
                <input hidden="hidden" id="zid" name="zid" value="" />
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
            <fieldset style="float:left;display:inline-block;color:white;">Flexibilit�t dank Bedenkzeit</fieldset>
        </form> <br /> <br />
        <form>
            
        </form>    
    </body>
    <script type="text/javascript">
        var verbindungen = JSON.parse('${fo}');
        console.log(Object.keys(verbindungen));
        Object.keys(verbindungen).forEach(function (key) {
            var opt = document.createElement('option');
            opt.innerHTML = key;
            opt.value = key;
            document.getElementById("abflug").appendChild(opt);
        });
        
        function changed(selectObject){
            var selected = selectObject.value;
            var box = document.getElementById("ankunft");
            var length = box.options.length;
            for (i = length-1; i >= 0; i--) {
            box.options[i] = null;
            }
            verbindungen[selected].forEach(function (cont){
                
                var opt = document.createElement('option');
                
            opt.innerHTML = cont['ankunft'];
            opt.value = cont['ankunft'];
                document.getElementById("ankunft").appendChild(opt);
            });
        }
        
        
      
    </script>
        
 
</html>

