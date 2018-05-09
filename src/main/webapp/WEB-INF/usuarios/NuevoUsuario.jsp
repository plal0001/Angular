<%-- 
    Document   : NuevoUsuario
    Created on : 24-feb-2018, 13:16:19
    Author     : josem
--%>
<%-- 
    Document   : PlantillaGeneral
    Created on : 24-feb-2018, 12:33:45
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
        <%@ include file="../templates/estilos.jspf" %>
    </head> 
     
    <%@include file="../templates/navbar.jspf" %>
    <body>
        <div class="row justify-content-center ">
            <div class="col-lg-8 row centrar-contenido box">
                <div class="col-md-4">
                    <h1>Usuario creado satisfactoriamente</h1>
                </div>
                <div class="col-md-4">
                <a class="btn btn-primary" href="/ButanClub/main/usuarios">Continuar</a>
            </div>
            </div>
            
        </div>

    </body>
    <%@include file="../templates/footer.jspf" %>
</html>

