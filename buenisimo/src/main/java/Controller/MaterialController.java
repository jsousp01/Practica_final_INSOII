package Controller;

import EJB.MaterialFacadeLocal;
import Entity.Material;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@SessionScoped
public class MaterialController implements Serializable{
 
    @EJB
    private MaterialFacadeLocal materialFacade;
    private List<Material> listaMaterial;
    private Material material;
    String mensaje = "";

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
    public void guardar(){
        try {
            this.materialFacade.create(material);
            this.material = new Material();
            this.mensaje = "Almacenado Con exito";
        } catch (Exception e) {
            e.printStackTrace();
            this.mensaje = "Error : " + e.getMessage();
        }
        FacesMessage mens = new FacesMessage(this.mensaje);
        FacesContext.getCurrentInstance().addMessage(null, mens);
    }
    
    public void actualizar(){
        try {
            this.materialFacade.edit(material);
            this.material = new Material();
            this.mensaje = "Actualizado Con exito";
        } catch (Exception e) {
            e.printStackTrace();
            this.mensaje = "Error : " + e.getMessage();
        }
        FacesMessage mens = new FacesMessage(this.mensaje);
        FacesContext.getCurrentInstance().addMessage(null, mens);
    }
    public void eliminar(Material c){
        try {
            this.materialFacade.remove(c);
            this.material = new Material();
            this.mensaje = "Eliminado Con exito";
        } catch (Exception e) {
            e.printStackTrace();
            this.mensaje = "Error : " + e.getMessage();
        }
        FacesMessage mens = new FacesMessage(this.mensaje);
        FacesContext.getCurrentInstance().addMessage(null, mens);
    }
    public void cargarID(Material c){
        this.material = c;
    }
    public void limpiar(){
        this.material = new Material();
    }
    
}
