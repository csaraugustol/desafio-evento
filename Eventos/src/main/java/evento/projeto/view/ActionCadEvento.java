/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package evento.projeto.view;

import evento.projeto.controller.commander.GenericCommander;
import evento.projeto.dao.EventoDao;
import evento.projeto.models.Evento;
import java.io.IOException;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author cesar
 */
public class ActionCadEvento extends GenericCommander {

    public ActionCadEvento(boolean isLogado) {
        super(isLogado);
    }
    
     
    

    @Override
    public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       
       RequestDispatcher rd = request.getRequestDispatcher("_layout.jsp");

        request.setAttribute("pg", "views/cad_evento");
       
        String titulo, botao;
        Evento eBusca = new Evento();
        eBusca.setDataFim(new Date());
          eBusca.setDataInicio(new Date());
          
          
        if (request.getParameter("id") != null) {
            titulo = "Alterar Evento";
            botao = "Salvar Alteração";
            eBusca = EventoDao.BuscaPorId(Integer.parseInt(request.getParameter("id")));
            
        } else {
            titulo = "Cadastrar Evento";
            botao = "Salvar Evento";
        }

        
        request.setAttribute("eventoBusc", eBusca);
        request.setAttribute("titulo", titulo);
        request.setAttribute("botao", botao);
        rd.forward(request, response);
        
        rd.forward(request, response);
    }

}
