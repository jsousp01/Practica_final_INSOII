/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import Entity.Juguete;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Jose
 */
@Local
public interface JugueteFacadeLocal {

    void create(Juguete juguete);

    void edit(Juguete juguete);

    void remove(Juguete juguete);

    Juguete find(Object id);

    List<Juguete> findAll();

    List<Juguete> findRange(int[] range);

    int count();
    
}
