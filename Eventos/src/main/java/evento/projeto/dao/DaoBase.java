/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package evento.projeto.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author cesar
 */
public class DaoBase<C, k> {

    private static EntityManagerFactory emf;

    private static EntityManager conexao;

    public static void close(){
        if(conexao.isOpen()){
        conexao.close();
        }
    }
    
    public static EntityManager getConexao(){

        if(conexao == null || !conexao.isOpen()){
            emf = Persistence.createEntityManagerFactory("Cesar");
            conexao = emf.createEntityManager();
    }
        return conexao;
}
    
}
