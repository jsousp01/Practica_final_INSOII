/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import Entity.Tareas;
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
public class TareasFacade extends AbstractFacade<Tareas> implements TareasFacadeLocal {

    @PersistenceContext(unitName = "com.mycompany_buenisimo_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TareasFacade() {
        super(Tareas.class);
    }

    
    @Override
    public List<Tareas> tareasAsignadas(Usuarios us) {
        String consulta = "SELECT u FROM Tareas u WHERE u.persona.idPersona=?1";
        Query query = em.createQuery(consulta);
        query.setParameter(1, us.getPersona().getIdPersona());
        List<Tareas> lista = query.getResultList();
        return lista;
    }

}
