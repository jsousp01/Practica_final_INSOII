package Controller;

import EJB.JugueteFacadeLocal;
import EJB.MaterialFacadeLocal;
import Entity.Juguete;
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
public class JugueteController implements Serializable {

    @EJB
    private JugueteFacadeLocal jugueteFacade;
    @EJB
    private MaterialFacadeLocal materialFacade;
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

    public void guardar() {
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

    public void distribuir(int cantidad, int idJuguete) {
        try {
            this.juguete.setCantidad(this.juguete.getCantidad() - cantidad);
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

    public void eliminar(Juguete c) {
        try {
            List<Material> lista = this.jugueteFacade.materialesAsociados(c);
            Material mat;
            for (int i = 0; i < lista.size(); i++) {
                mat = lista.get(i);
                this.materialFacade.remove(mat);
            }
            this.jugueteFacade.remove(c);
            this.juguete = new Juguete();
            this.mensaje = "Eliminado Con exito";
        } catch (Exception e) {
            e.printStackTrace();
            this.mensaje = "Error : " + e.getMessage();
        }
        FacesMessage mens = new FacesMessage(this.mensaje);

        FacesContext.getCurrentInstance()
                .addMessage(null, mens);
    }

    public void cargarID(Juguete c) {
        this.juguete = c;
        System.out.println(c.getIdJuguete() + "  asnfdoudonfanoinfoasd");
        
    }

    public void limpiar() {
        this.juguete = new Juguete();
    }

}
