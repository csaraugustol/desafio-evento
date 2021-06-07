/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package evento.projeto.dao;

import evento.projeto.models.Usuario;
import java.sql.SQLException;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Query;

/**
 *
 * @author cesar
 */
public class UsuarioDao extends DaoBase {

    public static boolean existeLogin(Usuario u) {
        Query q = getConexao().createQuery("select count(u) from Usuario u where u.email = :log");
        q.setParameter("log",u.getEmail());
        return (long)q.getSingleResult() > 0;
    }

    public Usuario verificaUsuario(String email, String senha) throws SQLException {

        Query q = getConexao().createQuery("select u from Usuario u where u.email = :email and u.senha = :senha");

        q.setParameter("email", email);
        q.setParameter("senha", senha);

        try {
            return (Usuario) q.getSingleResult();
        } catch (NonUniqueResultException e) {
            throw new SQLException("Foi encontrado dois ou mais usuários iguais registrados.");
        } catch (NoResultException e) {
            return null;
        }

    }

}
