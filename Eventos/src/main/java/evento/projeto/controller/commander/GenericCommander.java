/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package evento.projeto.controller.commander;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author cesar
 */
public abstract class GenericCommander {
    
    public boolean isLogged;

    public GenericCommander(boolean isLogged) {
        this.isLogged = isLogged;
    }
    
     public abstract void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;

    public boolean isIsLogged() {
        return isLogged;
    }

    public void setIsLogged(boolean isLogged) {
        this.isLogged = isLogged;
    }
}
