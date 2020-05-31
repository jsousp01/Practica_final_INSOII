/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import Entity.Persona;
import Entity.Roles;
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
public class PersonaFacade extends AbstractFacade<Persona> implements PersonaFacadeLocal {

    @PersistenceContext(unitName = "com.mycompany_buenisimo_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PersonaFacade() {
        super(Persona.class);
    }

    @Override
    public List<Usuarios> findTrabajadores(int idRol) {

        String consulta = "SELECT u FROM Usuarios u WHERE u.rol.idRol=?1";
        Query query = em.createQuery(consulta);
        query.setParameter(1, idRol);

        List<Usuarios> lista = query.getResultList();
        return lista;

    }

    @Override
    public List<Usuarios> usuariosAsociados(Persona idPersona) {
        String consulta = "SELECT u FROM Usuarios u WHERE u.persona.idPersona=?1";
        Query query = em.createQuery(consulta);
        query.setParameter(1, idPersona.getIdPersona());
        List<Usuarios> lista = query.getResultList();
        return lista;
    }

}
