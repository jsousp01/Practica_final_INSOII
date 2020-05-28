package Controller;

import EJB.MaterialFacadeLocal;
import Entity.Material;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class managedMaterial implements Serializable{
 
    @EJB
    private MaterialFacadeLocal materialFacade;
    private List<Material> listaMaterial;
    private Material material;

    public List<Material> getListaMaterial() {
        this.listaMaterial = this.materialFacade.findAll();
        return listaMaterial;
    }

    public void setListaMaterial(List<Material> listaMaterial) {
        this.listaMaterial = listaMaterial;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }
    
    @PostConstruct
    public void init() {
        this.material = new Material();
    }
    
}
