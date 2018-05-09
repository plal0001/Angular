<%--
    Document   : comprar entrada
    Created on : 25-feb-2018, 17:13:24
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
                    <div class="col-md-4">
                        <%@include file="/WEB-INF/templates/modulos/datos-usuario-entradas.jspf" %>
                    </div>
                    <div class="col-md-4">
                        <%@include file="/WEB-INF/templates/modulos/datos-concierto.jspf" %>
                    </div>

                </div>
                <br>
                <div class="row centrar-contenido">
                    <form action="${svlURL}/ConfirmacionCompra" method="POST">
                        <input type="text" name="concierto-comprado" hidden value="${conciertoCompra.id}">
                        <input type="text" name="usuario-comprador" hidden value="${pageContext.request.remoteUser}">
                        <label>
                            Numero entradas:
                        </label>
                        <input name="numero-entradas" type="number" value="1">
                        <br>
                        <input class="btn btn-primary" type="submit" name="confirmacion-compra" value="Comprar Entrada">
                    </form>
                </div>
            </div>
        </div>

    </body>
    <%@include file="/WEB-INF/templates/footer.jspf" %>
</html>

</html>
