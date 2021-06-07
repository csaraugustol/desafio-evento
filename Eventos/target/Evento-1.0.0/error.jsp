
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="layout-main"> 


            <section class="row container-fluid"  >
                <%
                    String error = (String) request.getAttribute("error");
                %>
                <h1>Erro no sistema::</h1>
                <h2><% out.println(error);%><h2>
                        </section>

                        </div>
                        </body>
                        </html>
