<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <head>
        <title>Start Page</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
        <link rel="stylesheet" type="text/css" href="https://cdn.jsdelivr.net/npm/font-awesome@4.7.0/css/font-awesome.min.css" />
        <link rel="stylesheet" type="text/css" href="https://cdn.jsdelivr.net/npm/animsition@4.0.2/dist/css/animsition.min.css" />
        <link rel="stylesheet" href="css/layout.css">
    </head>
    <body class="bg-primary">
       <main class="container border shadow-lg p-3 mb-5 bg-body rounded mt-5 w-50 bg-white">

            <div class="container-fluid w-50 " style="height: 550px;">

                <div class="login-section-wrapper">
                    <div class="brand-wrapper text-center">
                        <h1 class="logo-badge text-whitesmoke"><span class="fa fa-user-circle"></span></h1>
                    </div>
                    <div class="login-wrapper my-auto ">
                        <h1 class="login-title text-center">Log in</h1>
                        <form action="control" method="post">
                            <input type="hidden" name="ac" value="login">

                            <%
                                String success = request.getParameter("su");
                                if (success != null) {
                            %>
                            <div class="alert alert-success" role="alert">
                                Cadastro feito com <strong>sucesso</strong>!
                            </div>
                            <%}%>


                            <div class="form-group">
                                <label for="email">Email</label>
                                <input required type="email" name="email" id="email" class="form-control" placeholder="Email@exemplo.com">
                            </div>
                            <div class="form-group mb-4">
                                <label for="senha">Senha</label>
                                <input required type="password" name="senha" id="password" class="form-control" placeholder="Digite sua senha..">
                            </div>


                            <c:if test="${requestScope.e != null}">
                                <div class="alert alert-danger" role="alert">
                                    <strong>E-Mail</strong> ou <strong>Senha</strong> incorreto(s)
                                </div>
                            </c:if>

                            <c:if test="${requestScope.a != null}">
                                <div class="alert alert-dark" role="alert">
                                    Faça o <strong>Login</strong> para continuar!
                                </div>
                            </c:if>




                            <input name="login" id="login" class="btn btn-block btn-outline-primary login-btn " type="submit" value="Login">
                        </form>
                        <br>
                        <p class="login-wrapper-footer-text text-center"><a href="control?ac=newUser" class="text-reset text-danger">Cadastre-se</a></p>
                    </div>
                </div>

            </div>
        </div>


        <div class="footer text-center text-primary">
            Tokenlab Eventos ® - 2021
        </div>
    </main>

    <script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-Piv4xVNRyMGpqkS2by6br4gNJ7DXjqk09RmUpJ8jgGtD7zP9yug3goQfGII0yAns" crossorigin="anonymous"></script>
    <script>

    </script>
</body>
</html>