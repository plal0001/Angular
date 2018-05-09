<%--
    Document   : EditaUsuario
    Created on : 17-mar-2018, 11:56:37
    Author     : Pedro Luis
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


        <div class="row justify-content-center">
            <div class=" box col-lg-8 ">
                <center>
                    <form method="POST">
                        <fieldset>
                            <legend>
                                <h2>Edita Usuario</h2>

                            </legend>

                            <input hidden type="text" value="${usuario.usuario}" name="usuario" required class="form-control" >
                            <label>Contraseña: <input type="password" name="pass" value="${usuario.contraseña}" required class="form-control"></label>
                            <label>Confirme Contraseña: <input type="password" value="${usuario.contraseña}" required name="confirmacion-pass" class="form-control"></label>

                            <label>Nombre: <input type="text" value="${usuario.nombre}" name="nombre" required class="form-control"></label>

                            <label>Apellidos: <input type="text" value="${usuario.apellidos}" name="apellidos" required class="form-control"></label>

                            <label>E-mail: <input type="email" name="email" value="${usuario.correo}" required class="form-control"></label>

                            <label>Fecha Nacimiento: <input type="date" value="${usuario.fNacimiento}" required name="fecha" class="form-control"></label>

                            <label>Teléfono: <input type="tel" name="tlfn" value="${usuario.telefono}" required class="form-control"></label>
                            <c:if test="${pageContext.request.isUserInRole('Administrador')}">
                            <label>Tipo Usuario: <select value="${log.tipoUsuario}" name="tipoUsuario" class="form-control">

                                    <option default value="Administrador">Administrador</option>
                                    <option value="Registrado">Registrado</option>
                                    <option value="Artista">Artista</option>
                                </select></label>
                            </c:if>
                            <c:if test="${pageContext.request.isUserInRole('Artista')}">
                            <label>Tipo Usuario: <select value="${log.tipoUsuario}" name="tipoUsuario" class="form-control">
                                    <option default value="Artista">Artista</option>
                                    <option value="Registrado">Registrado</option>

                                </select></label>
                            </c:if>
                            <c:if test="${pageContext.request.isUserInRole('Registrado')}">
                            <label>Tipo Usuario: <select value="${log.tipoUsuario}" name="tipoUsuario" class="form-control">

                                    <option default value="Registrado">Registrado</option>

                                </select></label>
                            </c:if>

                        </fieldset>

                        <input type="submit" name="altaUsuario" value="Guardar" class="btn btn-primary">
                        <input type="reset" name="reset" value="Reestablecer" class="btn">

                    </form>
                </center>
            </div>
        </div>

    </body>
    <%@include file="/WEB-INF/templates/footer.jspf" %>
</html>
