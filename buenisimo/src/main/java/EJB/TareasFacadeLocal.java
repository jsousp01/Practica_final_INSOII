/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import Entity.Juguete;
import Entity.Material;
import Entity.Tareas;
import Entity.Usuarios;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Anto
 */
@Local
public interface TareasFacadeLocal {

    void create(Tareas tareas);

    void edit(Tareas tareas);

    void remove(Tareas tareas);

    Tareas find(Object id);

    List<Tareas> findAll();

    List<Tareas> findRange(int[] range);

    int count();
    
    public List<Tareas> tareasAsignadas(Usuarios us);
    
}
