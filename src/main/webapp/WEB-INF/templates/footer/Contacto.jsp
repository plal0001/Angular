<%-- 
    Document   : Contacto
    Created on : 28-feb-2018, 19:38:14
    Author     : josem
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">         
        <title></title>
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1"> 
        <!--<link rel="stylesheet" href="css/normalize.css">
        <link rel="stylesheet" href="css/font-awesome.css">  
        -->
        <%@include file="../estilos.jspf" %>
    </head> 
    <%@include file="../header.jspf" %>
    <%@include file="../navbar.jspf" %>
    <body>


        <div class="row justify-content-center">
            <div class="col-lg-8 ">
                <div class="box centrar-contenido">
                    
                       
                        <%if (request.getParameter("contactar") == null) {%>
                        <form >
<div class="justify-content-center">
     <h2>Contacto</h2>
                            <label>Nombre:</label><br>
                            <input  type="text" name="nombre" placeholder="Tu Nombre completo"><br>
                            <label>Email:</label><br>
                            <input type="email" name="email" placeholder="El email al que responderemos"><br>                    
                            <label>Mensaje:</label><br>
                            <textarea type="text"  name="Mensaje" rows="10" cols="50"></textarea><br>
                            <input type="submit" name="contactar" value="Contactar" class="btn btn-primary">
                             </div>
                        </form>
                        <%} else { %>
                        <h3>Mensaje enviado, nos pondremos en contacto con usted lo antes posible.</h3>
                        <% }%>
                   
                </div>
            </div>
        </div>

    </body>
    <%@include file="../footer.jspf" %>
</html>

</html>

