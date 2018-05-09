<%--
    Document   : conciertos
    Created on : 24-feb-2018, 13:33:45
    Author     :plal
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Butan-Conciertos</title>
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!--<link rel="stylesheet" href="css/normalize.css">
        <link rel="stylesheet" href="css/font-awesome.css">
        -->
        <%@include file="/WEB-INF/templates/estilos.jspf" %>
    </head>

    <%@include file="/WEB-INF/templates/navbar.jspf" %>
    <body>


        <div class="row justify-content-center">
            <div class=" row centrar-contenido box">
                <h2>Conciertos</h2>
                <%@include file="/WEB-INF/templates/modulos/muestra-conciertos.jspf" %>
            </div>
        </div>

    </body>
    <%@include file="/WEB-INF/templates/footer.jspf" %>
</html>