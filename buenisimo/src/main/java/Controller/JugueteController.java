package Controller;

import EJB.JugueteFacadeLocal;
import Entity.Juguete;
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
public class JugueteController implements Serializable{
 
    @EJB
    private JugueteFacadeLocal jugueteFacade;
    private List<Juguete> listaJuguete;
    private Juguete juguete;
    String mensaje = "";

    public List<Juguete> getListaJuguete() {
        this.listaJuguete = this.jugueteFacade.findAll();
        return listaJuguete;
    }

    public void setListaJuguete(List<Juguete> listaJuguete) {
        this.listaJuguete = listaJuguete;
    }

    public Juguete getJuguete() {
        return juguete;
    }

    public void setJuguete(Juguete juguete) {
        this.juguete = juguete;
    }
    
    @PostConstruct
    public void init() {
        this.juguete = new Juguete();
    }
    
    public void guardar(){
        try {
            this.jugueteFacade.create(juguete);
            this.juguete = new Juguete();
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
            this.jugueteFacade.edit(juguete);
            this.juguete = new Juguete();
            this.mensaje = "Actualizado Con exito";
        } catch (Exception e) {
            e.printStackTrace();
            this.mensaje = "Error : " + e.getMessage();
        }
        FacesMessage mens = new FacesMessage(this.mensaje);
        FacesContext.getCurrentInstance().addMessage(null, mens);
    }
    public void eliminar(Juguete c){
        try {
            this.jugueteFacade.remove(c);
            this.juguete = new Juguete();
            this.mensaje = "Eliminado Con exito";
        } catch (Exception e) {
            e.printStackTrace();
            this.mensaje = "Error : " + e.getMessage();
        }
        FacesMessage mens = new FacesMessage(this.mensaje);
        FacesContext.getCurrentInstance().addMessage(null, mens);
    }
    public void cargarID(Juguete c){
        this.juguete = c;
    }
    public void limpiar(){
        this.juguete = new Juguete();
    }
    
}
