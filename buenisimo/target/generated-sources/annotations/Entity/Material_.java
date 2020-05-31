package Entity;

import Entity.Juguete;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2020-05-31T20:28:42")
@StaticMetamodel(Material.class)
public class Material_ { 

    public static volatile SingularAttribute<Material, Integer> idMaterial;
    public static volatile SingularAttribute<Material, Integer> cantidad;
    public static volatile SingularAttribute<Material, String> nombre;
    public static volatile SingularAttribute<Material, Juguete> idJuguete;

}