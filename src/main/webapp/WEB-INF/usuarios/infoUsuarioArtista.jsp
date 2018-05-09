<%--
    Document   : respuesta
    Created on : 16-feb-2018, 16:26:26
    Author     : josem
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        <div class="box">
            <h1> Bienvenido ${log.nombre}.
                <div class="row float-right">
                    <a class="btn btn-primary separacion-derecha" href="${svlURL}/edita?usuario-edita=${log.usuario}"> Editar perfil</a>
                    <a class="btn btn-primary" href="<c:url value="/logOut"/>"> Cerrar sesión</a>
                </div>
            </h1>

        </div>
    </div>
    <div class="box">
        <%-- informacion de usuarios --%>
        <div class="row centrar-contenido">
            <h2>Tus conciertos</h2>
            <br>
        </div>
        <%@include file="/WEB-INF/templates/modulos/conciertos-usuario.jspf" %>

    </div> <
    <div class="box">
        <%-- informacion de artistas --%>

        <%@include file="/WEB-INF/templates/modulos/solicitar-sala.jspf" %>



    </div>



</body>
<%@include file="/WEB-INF/templates/footer.jspf" %>
</html>

