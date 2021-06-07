/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package evento.projeto.view;

import evento.projeto.controller.commander.GenericCommander;
import evento.projeto.dao.EventoDao;
import evento.projeto.models.Evento;
import evento.projeto.models.Usuario;
import evento.projeto.view.ActionCadEvento;
import evento.projeto.view.ActionListaEventos;
import java.io.IOException;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author cesar
 */
public class ViewSalvarEventoAction extends GenericCommander {

    public ViewSalvarEventoAction(boolean isLogged) {
        super(isLogged);
    }

    @Override
    public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Evento e = new Evento();
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            Date date = new Date();
            Date date2 = new Date();
            String msg;
            
            Usuario u = (Usuario) request.getSession().getAttribute("user");

            date = formatter.parse(request.getParameter("dataInicio"));
            date2 = formatter.parse(request.getParameter("dataFim"));

            if (request.getParameter("cpId") == null) {

                String descricao = request.getParameter("descricao");

                e.setDescricao(descricao);

                e.setDataInicio(date);
                e.setDataFim(date2);

                e.setIdusuario(u);
                msg = "Evento salvo com sucesso.";

            } else {
                //e = EventoDao.BuscaPorId(Integer.parseInt(request.getParameter("cpId")));

                e.setDescricao(request.getParameter("descricao"));
                e.setDataInicio(date);
                e.setDataFim(date2);

                msg = "Alteção realizada com sucesso.";

            }

            EventoDao.getConexao().getTransaction().begin();
            EventoDao.getConexao().persist(e);
            EventoDao.getConexao().getTransaction().commit();
//
            request.setAttribute("msg", msg);

            response.sendRedirect("control?ac=eventos");

        } catch (ParseException ex) {
            throw new ServletException("Erro ao converter a data");
        }

//        new ActionListaEventos(isLogged).executa(request, response);
    }

}
