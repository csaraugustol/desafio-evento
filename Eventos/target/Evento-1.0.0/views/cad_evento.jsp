<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>           

<h1 class="display-5">${requestScope.titulo}</h1>

<div class="container-fluid corpo">
    <div class="row justify-content-md-center h-100 p-5">
        <div class="card-wrapper">
            <div class="card fat">
                <div class="card-body bg-primary text-light" >
                    <h4 class="card-title text-center"></h4>
                    <form method="POST" class="my-login-validation"
                          action="control?ac=salvarEvento">
                        <!--<input type="hidden" name="ac" value="salvarEvento"/>-->
                        <div class="form-group">
                            <label for="descricao">Descrição</label>
                            <input id="descricao" type="text" class="form-control" name="descricao"
                                   value="" required="" autofocus="" placeholder="Descrição" >
                        </div>

                        <div class="form-group">
                            <label for="dataInicio">Data Início</label>
                            <input id="dataInicio" type="date" class="form-control" name="dataInicio"
                                   value="" required="" autofocus="" >
                        </div>

                        <div class="form-group">
                            <label for="dataFim">Data Fim</label>
                            <input id="dataFim" type="date" class="form-control" name="dataFim"
                                   value="" required="" autofocus="" >
                        </div>

                        <div class="form-group m-0">
                            <button id="bntCadastro" type="submit" class="btn btn-warning btn-block">
                                ${requestScope.botao}
                            </button>
                        </div>
                        <div class="mt-4 text-center">
                            <a class="text-light" href="control?ac=eventos">Voltar</a>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>



<script>

//    $("#bntCadastro").on("click", function (e) {
//        window.location = "control?ac=salvarEvento";
//    });

</script>