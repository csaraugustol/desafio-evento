/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package evento.projeto.controller.commander.VerifySave;

import evento.projeto.controller.commander.GenericCommander;
import evento.projeto.dao.UsuarioDao;
import evento.projeto.models.Usuario;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author cesar
 */
public class ActionSalvarUsuario extends GenericCommander {

    public ActionSalvarUsuario(boolean isLogged) {
        super(isLogged);
    }

    @Override
    public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String nome = request.getParameter("nome");
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");

        Usuario u = new Usuario(1, nome, email, senha);

        if (UsuarioDao.existeLogin(u)) {

            request.setAttribute("user", u);
            RequestDispatcher rd = request.getRequestDispatcher("control?ac=newUser&ex=1");
            rd.forward(request, response);
        } else {

            UsuarioDao.getConexao().getTransaction().begin();
            UsuarioDao.getConexao().persist(u);
            UsuarioDao.getConexao().getTransaction().commit();
            response.sendRedirect("control?su=1");

        }
    }

}
