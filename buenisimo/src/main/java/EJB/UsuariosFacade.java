/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import Entity.Usuarios;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Anto
 */
@Stateless
public class UsuariosFacade extends AbstractFacade<Usuarios> implements UsuariosFacadeLocal {

    @PersistenceContext(unitName = "com.mycompany_buenisimo_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuariosFacade() {
        super(Usuarios.class);
    }

    @Override
    public Usuarios verificarUsuario(Usuarios us) {
        Usuarios usuario = null;
        String consulta = "SELECT u FROM Usuarios u WHERE u.usuario=?1 and u.contrasena=?2";
        Query query = em.createQuery(consulta);
        query.setParameter(1, us.getUsuario());
        query.setParameter(2, us.getContrasena());
        List<Usuarios> lista = query.getResultList();
        if (!lista.isEmpty()) {
            usuario = lista.get(0);
        }
        return usuario;
    }

}
