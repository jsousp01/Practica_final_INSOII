package Controller;

import EJB.JugueteFacadeLocal;
import Entity.Juguete;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class managedJuguete implements Serializable{
 
    @EJB
    private JugueteFacadeLocal jugueteFacade;
    private List<Juguete> listaJuguete;
    private Juguete juguete;

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
    
}
