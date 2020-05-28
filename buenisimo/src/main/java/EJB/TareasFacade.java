/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import Entity.Tareas;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
    
}
