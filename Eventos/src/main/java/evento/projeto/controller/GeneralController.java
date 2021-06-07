/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package evento.projeto.controller;

import evento.projeto.view.ActionExluirEvento;
import evento.projeto.view.ViewSalvarEventoAction;
import evento.projeto.view.ActionListaEventos;
import evento.projeto.controller.commander.GenericCommander;
import evento.projeto.controller.commander.VerifySave.ActionSalvarUsuario;
import evento.projeto.controller.commander.VerifySave.ActionVerificaLogin;
import evento.projeto.controller.commander.VerifySave.ActionVerificaLogout;
import evento.projeto.models.Usuario;
import evento.projeto.view.ActionCadEvento;
import evento.projeto.view.ActionViewHome;
import evento.projeto.view.ActionViewLogin;
import evento.projeto.view.ActionViewRegister;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Cesar
 */
@WebServlet(name = "GeneralController", urlPatterns = {"/control"})
public class GeneralController extends HttpServlet {

    static HashMap<String, GenericCommander> comandos;

    static {
        comandos = new HashMap<>();
        comandos.put(null, new ActionViewLogin(false));
        comandos.put("login", new ActionVerificaLogin(false));
        comandos.put("newUser", new ActionViewRegister(false));
        comandos.put("cadUser", new ActionSalvarUsuario(false));
        comandos.put("home", new ActionViewHome(true));
        comandos.put("logout", new ActionVerificaLogout(false));
        comandos.put("eventos", new ActionListaEventos(true) ); 
        comandos.put("salvarEvento", new ViewSalvarEventoAction(true));
        comandos.put("editEvento", new ViewSalvarEventoAction(true));
        comandos.put("cadEventos", new ActionCadEvento(true));
        comandos.put("exluirEvento", new ActionExluirEvento(true));
        
    }

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

         Usuario u = new Usuario(Integer.MIN_VALUE, request.getParameter("nome"), request.getParameter("email"),
                request.getParameter("senha"));
        
        try (PrintWriter out = response.getWriter()) {
            String acao = request.getParameter("ac");
            try {
                if (!comandos.get(acao).isIsLogged() || request.getSession().getAttribute("user") != null) {
                    comandos.get(acao).executa(request, response);
                } else {
                    request.setAttribute("a", "1");
                    new ActionViewLogin(false).executa(request, response);
               
                }
            } catch (Exception e) {
                RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
                request.setAttribute("error", e.getMessage() == null ? "Ação não encontrada" : e.getMessage());
                rd.forward(request, response);
            }

        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
