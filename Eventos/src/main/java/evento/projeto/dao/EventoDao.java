package evento.projeto.dao;

import evento.projeto.dao.DaoBase;
import static evento.projeto.dao.DaoBase.getConexao;
import evento.projeto.models.Evento;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.Query;

/**
 *
 * @author Pedro
 */
public class EventoDao extends DaoBase {

    public static List<Evento> returnAll() {
        Query q = getConexao().createNamedQuery("Evento.findAll");

        return q.getResultList();
    }

    public static List<Evento> returnSearch(String descricao) {
        Query q = getConexao().createQuery("SELECT e FROM Evento e WHERE e.descricao LIKE :descricao");

        
            q.setParameter("descricao", "%" + descricao.toLowerCase() + "%");
        
       

        return q.getResultList();

    }

    public static Evento returnId(int id) {
        Query q = getConexao().createNamedQuery("Evento.findByIdevento");
        q.setParameter("idevento", id);
        return (Evento) q.getSingleResult();
    }
    
    public static Evento retornaTodosEvents() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static boolean existeNome(Evento e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static Evento BuscaPorId(int id) {
        Query q = getConexao().createNamedQuery("Evento.findByIdevento");
        
        q.setParameter("idevento", id);
        
        try {
             return (Evento) q.getSingleResult();
        } catch (NoResultException e) {
        }
          
        return null;
    }

  
}
