<%@page import="evento.projeto.models.Usuario"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link rel="stylesheet" type="text/css" href="css/tela_eventos.css" />
<!DOCTYPE html>



<div class="container">
    <%
        Usuario u = (Usuario) session.getAttribute("user");
    %>

    <div class="col-6">
        <% if (request.getAttribute("msg") != null) {%>
        <div class="alert-success text-center">

            <%= request.getAttribute("msg")%>

        </div>
        <%}%>
    </div>

    <fieldset>
        <legend>Pesquisar</legend>
        <form action="control" method="POST" class="bg-warning w-75 mb-5 container"> 
            <input type="hidden" name="ac" value="eventos" />
            <input type="hidden" name="search" value="1"/>

            <div class="row">
                <div class="col-12">                  
                    <div class="form-group">                 
                        <label for="evento">Descrição</label> 
                        <input type="text" name="buscaNome" class="form-control"
                               placeholder="Descrição para busca" value=""/>  

                        <!--                    </div>
                                            <div class="col-12"> 
                        
                                                <div class="form-group">                 
                                                    <label for="evento">Data Evento:</label> <br>
                                                    De: <input value="" type="date" name="data1" class="form-control"/>  
                                                    Até <input value="" type="date" name="data2" class="form-control"/>  
                        
                                                </div>
                                            </div>-->

                        <div class="form-group mt-2" >               
                            <button type="submit" class="btn btn-primary" >Pesquisar</button>
                        </div>

                    </div>

                    </form>
                    </fieldset>

                    <table class="table table-hover">
                        <thead>
                            <tr>
                                <td>#</td>
                                <td>Descrição</td>
                                <td>Data Início</td>
                                <td>Data Fim</td>
                                <td>Ação</td>
                            </tr>
                        </thead>
                        <tbody>
                            <c:if test="${requestScope.times.size() == 0}">
                                <tr>
                                    <td class="text-center" colspan="3"> Não há Times Cadastrados</td>
                                </tr> 
                            </c:if>

                            <%int count = 1;%> 
                            <c:forEach var="evento" items="${requestScope.eventosCadastrados}">
                                <tr>

                                    <td><%=count++%></td> 

                                    <td>${evento.descricao}</td>

                                    <td>
                                        <fmt:formatDate value="${evento.dataInicio}" type="date" pattern="dd/MM/yyyy"/>
                                    </td>

                                    <td>
                                        <fmt:formatDate value="${evento.dataFim}" type="date" pattern="dd/MM/yyyy"/>
                                    </td>

                                    <td>
                                        <a class="btnEditEv" href="control?ac=editEvento&id=${evento.idevento}"><span><i class="fa fa-edit"></i></span></a>

                                        <a class="btnExcluir" href="#" data-toggle="modal" data-target="#alertaModal"
                                           data-evento="${evento.descricao}" data-id="${evento.idevento}"><span><i class="fa fa-trash"></i></span>

                                        </a>


                                    </td>

                                </tr>
                            </c:forEach>


                        </tbody>

                    </table>
                    <div>
                        <a class=" btn btn-primary" href="control?ac=eventos" role="button">Nova Busca</a>
                    </div>


                    <!-- Modal -->
                    <div class="modal fade" id="alertaModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <div class="modal-header bg-warning">
                                    <h5 class="modal-title" id="exampleModalLabel">Deseja confirmar a exclusão?</h5>
                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                        <span aria-hidden="true">&times;</span>
                                    </button>
                                </div>
                                <div class="modal-body">
                                    Confirma a exclusão do evento <span id="evento" class="font-weight-bold"></span>?
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Não</button>
                                    <button id="btnExcEvento" type="button" class="btn btn-danger">Sim</button>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>



                <script>

                    $(".btnExcluir").on("click", function (e) {

                        $("#evento").html($(e.currentTarget).data("evento"));

                        $("#btnExcEvento").data("id", $(e.currentTarget).data("id"));

                    });

                    $("#btnExcEvento").on("click", function (e) {
                        console.log($(e.currentTarget).data("id"));
                        window.location = "control?ac=exluirEvento&id=" + $(e.currentTarget).data("id");
                    });

                </script>