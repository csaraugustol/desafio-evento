/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package evento.projeto.controller.commander.VerifySave;

import evento.projeto.controller.commander.GenericCommander;
import evento.projeto.view.ActionViewHome;
import evento.projeto.view.ActionViewLogin;
import evento.projeto.dao.UsuarioDao;
import evento.projeto.models.Usuario;
import evento.projeto.view.ActionCadEvento;
import evento.projeto.view.ActionListaEventos;
import java.io.IOException;
import java.rmi.ServerException;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author cesar
 */
public class ActionVerificaLogin extends GenericCommander {

    public ActionVerificaLogin(boolean isLogged) {
        super(isLogged);
    }

    @Override
    public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String email = request.getParameter("email");
        String senha = request.getParameter("senha");

        Usuario u;
        try {
            u = new UsuarioDao().verificaUsuario(email, senha);
        } catch (SQLException ex) {
            throw new ServletException();
        }

        if (u != null) {

            Usuario u2 = new Usuario(u.getIdusuario(), u.getNome(), u.getEmail(), u.getSenha());
            request.getSession().setAttribute("user", u2);

              new ActionViewHome(isLogged).executa(request, response);

        } else {
            request.setAttribute("e", "1");
            new ActionViewLogin(false).executa(request, response);
            return;

        }

//        if (email.equals("123@123.com") && senha.equals("123")) {
//
//            new ActionViewHome(true).executa(request, response);
//
//        } else {
//            RequestDispatcher rd = request.getRequestDispatcher("access/login.jsp");
//            request.setAttribute("e", "sim");
//            rd.forward(request, response);
//        }
    }

}
