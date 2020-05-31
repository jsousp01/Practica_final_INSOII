package Entity;

import Entity.Juguete;
import Entity.Persona;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2020-05-31T20:28:42")
@StaticMetamodel(Tareas.class)
public class Tareas_ { 

    public static volatile SingularAttribute<Tareas, Persona> persona;
    public static volatile SingularAttribute<Tareas, Integer> idTarea;
    public static volatile SingularAttribute<Tareas, Integer> cantidad;
    public static volatile SingularAttribute<Tareas, Juguete> idJuguete;

}