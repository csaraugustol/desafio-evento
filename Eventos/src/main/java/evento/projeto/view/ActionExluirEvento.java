/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package evento.projeto.view;

import evento.projeto.controller.commander.GenericCommander;
import evento.projeto.dao.DaoBase;
import static evento.projeto.dao.DaoBase.getConexao;
import evento.projeto.dao.EventoDao;
import evento.projeto.models.Evento;
import evento.projeto.view.ActionListaEventos;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author cesar
 */
public class ActionExluirEvento extends GenericCommander {

    public ActionExluirEvento(boolean isLogged) {
        super(isLogged);
    }

    @Override
    public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id = request.getParameter("id");

   
        EventoDao.getConexao().getTransaction().begin();
        Evento e = EventoDao.returnId(Integer.parseInt(id));
        
        EventoDao.getConexao().remove(e);
        EventoDao.getConexao().getTransaction().commit();
        
        response.sendRedirect("control?ac=eventos");
    }

}
