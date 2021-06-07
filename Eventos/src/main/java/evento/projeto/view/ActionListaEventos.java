package evento.projeto.view;


import evento.projeto.dao.EventoDao;
import evento.projeto.controller.commander.GenericCommander;
import evento.projeto.models.Evento;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author cesar
 */
public class ActionListaEventos extends GenericCommander {

    public ActionListaEventos(boolean isLogged) {
        super(isLogged);
    }

    @Override
    public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

RequestDispatcher rd = request.getRequestDispatcher("_layout.jsp");
        request.setAttribute("pg", "views/eventos");
        List<Evento> eventosCadastrados;
        if (request.getParameter("search") == null) {
            eventosCadastrados = EventoDao.returnAll();
            if (eventosCadastrados.size() == 0) {
                request.setAttribute("eventosCadastrados", null);
            } else {
                request.setAttribute("eventosCadastrados", eventosCadastrados);
            }
        }else if(
                request.getParameter("buscaNome").equals("") && 
                request.getParameter("data1").equals("") &&
                request.getParameter("data2").equals("")){
             eventosCadastrados = EventoDao.returnAll();
            if (eventosCadastrados.size() == 0) {
                request.setAttribute("eventosCadastrados", null);
            } else {
                request.setAttribute("eventosCadastrados", eventosCadastrados);
            }
        }else{
            String nome = request.getParameter("buscaNome");
            String data1 = request.getParameter("data1");
            String data2 = request.getParameter("data2");
            
            eventosCadastrados = EventoDao.returnSearch(nome);
            
            if (eventosCadastrados.size() == 0) {
                request.setAttribute("eventosCadastrados", null);
            } else {
                request.setAttribute("eventosCadastrados", eventosCadastrados);
            }
        }

        rd.forward(request, response);
        
    }
    
}
