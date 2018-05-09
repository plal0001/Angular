<%--
    Document   : ConfirmacionCompra
    Created on : 25-feb-2018, 17:35:40
    Author     : Pedro Luis
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
        <%@include file="/WEB-INF/templates/estilos.jspf" %>
    </head>

    <%@include file="/WEB-INF/templates/navbar.jspf" %>
    <body>


        <div class="row justify-content-center">
            <div class="col-lg-8 box">
                <div class="row centrar-contenido">
                    <h1>Entradas compradas</h1>
                </div>
                <div class="row centrar-contenido">
                    <div class="col-md-4">
                        <%@include file="/WEB-INF/templates/modulos/datos-usuario-entradas.jspf" %>
                    </div>
                    <div class="col-md-4">
                        <%@include file="/WEB-INF/templates/modulos/datos-concierto.jspf" %>
                    </div>

                </div>
                <br>
                <div class="row centrar-contenido">
                    Numero de entardas:  ${entrada.cantidad}

                </div>
                <div class="row centrar-contenido">
                    <br>
                    <h2>Codigo de entradas: ${entrada.id}</h2>

                </div>
                <!-- <div class="row centrar-contenido">
                     <list>
                     <ul>
                <%//for(int i=0; i< Integer.parseInt(request.getParameter("numero-entradas"));i++){%>
                <li> <%//int a = (int)(Math.random()*999999);
                    // out.println(a);%> </li>
                <%//}%>
            </ul>
            </list>-->
            </div>
        </div>
    </div>
</div>

</body>
<%@include file="/WEB-INF/templates/footer.jspf" %>
</html>

</html>
