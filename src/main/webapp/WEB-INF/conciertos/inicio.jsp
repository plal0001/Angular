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
    <%@include file="/WEB-INF/templates/header.jspf" %>
    <%@include file="/WEB-INF/templates/navbar.jspf" %>
    <body>





        <div class="box-index">
            <%@include file="/WEB-INF/templates/modulos/proximos-conciertos.jspf" %>
        </div>


        <div id="myCarousel" class="carousel slide" data-ride="carousel">
            <ol class="carousel-indicators">
                <li data-target="#myCarousel" data-slide-to="0" class=""></li>
                <li data-target="#myCarousel" data-slide-to="1" class="active"></li>
                <li data-target="#myCarousel" data-slide-to="2" class=""></li>
            </ol>
            <div class="carousel-inner">
                <div class="carousel-item">
                    <img class="first-slide" src="imagenes/conciertos/concierto1.jpg" alt="First slide">
                    <div class="container justify-content-center">
                        <div class="carousel-caption ">
                            <h1>Example headline.</h1>
                            <p>Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.</p>
                            <p><a class="btn btn-lg btn-primary" href="#" role="button">Sign up today</a></p>
                        </div>
                    </div>
                </div>
                <div class="carousel-item active">
                    <img class="second-slide" src="imagenes/conciertos/concierto2.jpg" alt="Second slide">
                    <div class="container justify-content-center" >
                        <div class="carousel-caption">
                            <h1>Another example headline.</h1>
                            <p>Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.</p>
                            <p><a class="btn btn-lg btn-primary" href="#" role="button">Learn more</a></p>
                        </div>
                    </div>
                </div>
                <div class="carousel-item justify-content-center">
                    <img class="third-slide" src="imagenes/conciertos/concierto3.jpg" alt="Third slide">
                    <div class="container justify-content-center">
                        <div class="carousel-caption ">
                            <h1>One more for good measure.</h1>
                            <p>Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.</p>
                            <p><a class="btn btn-lg btn-primary" href="#" role="button">Browse gallery</a></p>
                        </div>
                    </div>
                </div>
            </div>
            <a class="carousel-control-prev" href="#myCarousel" role="button" data-slide="prev">
                <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                <span class="sr-only">Previous</span>
            </a>
            <a class="carousel-control-next" href="#myCarousel" role="button" data-slide="next">
                <span class="carousel-control-next-icon" aria-hidden="true"></span>
                <span class="sr-only">Next</span>
            </a>
        </div>
        <div class="box-index">
            <%@include file="/WEB-INF/templates/modulos/muestra-conciertos.jspf" %>
        </div>





        <div class= "index-parallax parallax row justify-content-center">
            <div class="centrar-contenido col-6">
                <div class="contenido-parallax">
                    <h3>Another example headline.</h3>
                    <p>Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.</p>
                    <p><a class="btn btn-lg btn-primary" href="#" role="button">Learn more</a></p>
                </div>
            </div>
        </div>

        <script src="/ButanClub/js/jquery-3.3.1.min.js"></script>
        <script  type="text/javascript" src="/ButanClub/js/bootstrap.min.js"></script>
    </body>
    <%@include file="/WEB-INF/templates/footer.jspf" %>
</html>
