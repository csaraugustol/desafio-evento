<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title></title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/open-iconic/1.1.1/font/css/open-iconic.min.css" integrity="sha512-LeCmts7kEi09nKc+DwGJqDV+dNQi/W8/qb0oUSsBLzTYiBwxj0KBlAow2//jV7jwEHwSCPShRN2+IWwWcn1x7Q==" crossorigin="anonymous" />
        <link rel="stylesheet" type="text/css" href="https://cdn.jsdelivr.net/npm/font-awesome@4.7.0/css/font-awesome.min.css" />
        <link rel="stylesheet" href="css/layout.css">
        <link rel="shortcut icon" href="../favicon.ico">
        <link rel="stylesheet" type="text/css" href="css/normalize.css" />
        <link rel="stylesheet" type="text/css" href="css/demo.css" />
        <link rel="stylesheet" type="text/css" href="css/component2.css" />
        <link rel="stylesheet" type="text/css" href="css/loader.css" />
        <script src="js/modernizr-2.6.2.min.js"></script>
        <script src="http://jqueryvalidation.org/files/dist/jquery.validate.js"></script>
        <script src="https://code.jquery.com/jquery-3.5.1.min.js" ></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-Piv4xVNRyMGpqkS2by6br4gNJ7DXjqk09RmUpJ8jgGtD7zP9yug3goQfGII0yAns" crossorigin="anonymous"></script>
    </head>

</head>
<body>

    <div class="d-flex flex-column bg-primary flex-md-row align-items-center p-3 px-md-4 mb-3 border-bottom box-shadow">
        <img src="img/tl-logo.png" width="150px" alt="Logo Tokenlab" class="my-0 mr-md-auto font-weight-normal text-light"/>
        <nav class="my-2 my-md-0 mr-md-3">
            <a class="p-2 text-light" href="control?ac=home">Home</a>
            <a class="p-2 text-light" href="control?ac=eventos">Eventos</a>
            <a class="p-2 text-light" href="control?ac=cadEventos">Novo Evento</a>
        </nav>
        <a class="btn btn-outline-light" href="control?ac=logout">Sair</a>
    </div>

    <div class="pricing-header px-3 py-3 pt-md-5 pb-md-4 mx-auto text-center">
        <h1 class="display-3">Tokenlab Eventos</h1>
        <p class="lead">Calendário de organização. Agende seu evento.</p>
    </div>

    <div class="container">



        <section class="container text-center ">
            <div class="col-12">

                <c:if test="${requestScope.pg == null}">
                    <jsp:include page='${requestScope.pg}.jsp'/>
                </c:if>
                <c:if test="${requestScope.pg != null}">
                    <jsp:include page='${requestScope.pg}.jsp'/>
                </c:if>

                <div class="text-right text-white">
                    Tokenlab Eventos ® - 2021
                </div>

            </div>  
        </section>


        <footer class="pt-4 my-md-5 pt-md-5 border-top">
            <div class="row">
                <div class="col-12 col-md text-center">
                    <small class="d-block mb-3 text-muted"> Tokenlab Eventos &copy; - 2021</small>
                </div>

            </div>
    </div>
</footer>
</div>


<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->

<script>

</script>
</body>
</html>

