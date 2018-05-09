<%-- 
    Document   : ResgistroUsuario
    Created on : 16-mar-2018, 19:39:25
    Author     : Pedro Luis
--%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
      <!--  <script type="text/javascript">
            function valida(form){
                var validado = true;
                var msg = "";
                if(form.usuario.length > 20 || form.usuario.length < 4){
                    msg="El nombre de usuario debe estar entre 4 y 20 caracteres";
                    validado=false;
                }
                if(form.pass.value !== form.pass_conf.value){
                    msg="Las contraseñas no coinciden";
                    validado=false;
                }
                if(validado===false){
                    alert(msg);
                }
                return validado;
            }
        </script>-->
    </head> 

    <%@include file="/WEB-INF/templates/navbar.jspf" %>
    <body>


        <div class="row justify-content-center">
            <div class=" box col-lg-8 ">
                <center>
                    <form:form  method="POST" modelAttribute="usuario">
                        <fieldset>
                            <legend>
                                <h2>Nuevo Usuario</h2>

                            </legend>

                            <label>Nombre de Usuario:<form:input type="text" path="usuario" class="form-control" /></label>
                            <label>Contraseña: <form:input type="password" path="contraseña" class="form-control"/></label>
                            <!-- La confirmacion de contraseña sería introducir un atributo en la clase usuario y sus respectivos cambios-->
                            <label>Nombre: <form:input type="text" path="nombre" class="form-control"/></label>

                            <label>Apellidos: <form:input type="text" path="apellidos"  class="form-control"/></label>

                            <label>E-mail: <form:input type="email" path="correo"  class="form-control"/></label>

                            <label>Fecha Nacimiento: <form:input type="date"  path="fNacimiento" class="form-control"/></label>

                            <label>Teléfono: <form:input type="tel" path="telefono" class="form-control"/></label>
                            
                            <form:hidden path="tipoUsuario" value="Registrado"/>

                        </fieldset>

                        <input type="submit" name="altaUsuario" value="Enviar" class="btn btn-primary">
                        <input type="reset" name="reset" value="Reestablecer" class="btn">

                    </form:form>
                </center>
            </div>
        </div>

    </body>
    <%@include file="/WEB-INF/templates/footer.jspf" %>
</html>


