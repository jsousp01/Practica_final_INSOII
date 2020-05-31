/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import Entity.Juguete;
import Entity.Material;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Jose
 */
@Stateless
public class JugueteFacade extends AbstractFacade<Juguete> implements JugueteFacadeLocal {

    @PersistenceContext(unitName = "com.mycompany_buenisimo_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public JugueteFacade() {
        super(Juguete.class);
    }
    
    
    @Override
    public List<Material> materialesAsociados(Juguete idJug) {
        String consulta = "SELECT u FROM Material u WHERE u.idJuguete.idJuguete=?1";
        Query query = em.createQuery(consulta);
        query.setParameter(1, idJug.getIdJuguete());
        List<Material> lista = query.getResultList();
        return lista;
    }
    
}
