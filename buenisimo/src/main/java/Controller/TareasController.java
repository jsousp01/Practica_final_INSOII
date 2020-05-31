/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import EJB.JugueteFacadeLocal;
import EJB.MaterialFacadeLocal;
import EJB.TareasFacadeLocal;
import Entity.Juguete;
import Entity.Material;
import Entity.Persona;
import Entity.Tareas;
import Entity.Usuarios;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Anto
 */
@ManagedBean
@SessionScoped
public class TareasController implements Serializable {

    @EJB
    private TareasFacadeLocal tareasFacade;
    private List<Tareas> listaTareas;
    private Tareas tarea;
    private Juguete juguete;
    @EJB
    private JugueteFacadeLocal jugueteFacade;
    @EJB
    private MaterialFacadeLocal materialFacade;
    private Persona persona;
    String mensaje = "";

    public List<Tareas> getListaTareas() {
        Usuarios uy = (Usuarios) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
        this.listaTareas = this.tareasFacade.tareasAsignadas(uy);
        return listaTareas;
    }

    public void setListaTareas(List<Tareas> listaTareas) {
        this.listaTareas = listaTareas;
    }

    public Tareas getTarea() {
        return tarea;
    }

    public void setTarea(Tareas tarea) {
        this.tarea = tarea;
    }

    public Juguete getJuguete() {
        return juguete;
    }

    public void setJuguete(Juguete juguete) {
        this.juguete = juguete;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    @PostConstruct
    public void init() {
        this.tarea = new Tareas();
        this.persona = new Persona();
        this.juguete = new Juguete();
    }

    public void guardar() {
        try {
            this.tarea.setPersona(persona);
            this.tarea.setIdJuguete(juguete);
            List<Material> lista = this.jugueteFacade.materialesAsociados(this.juguete);
            Material mat;
            int error = 0;
            for (int i = 0; i < lista.size(); i++) {
                mat = lista.get(i);
                if (this.tarea.getCantidad() > mat.getCantidad()) {
                    this.mensaje = "Necesitas un mayor numero del siguiente material: " + mat.getNombre();
                    error = 1;
                }
            }
            if (error == 0) {
                for (int i = 0; i < lista.size(); i++) {
                    mat = lista.get(i);
                    mat.setCantidad(mat.getCantidad() - this.tarea.getCantidad());
                    this.materialFacade.edit(mat);
                }
                this.tareasFacade.create(tarea);
                this.mensaje = "Almacenado Con exito";
            }
        } catch (Exception e) {
            e.printStackTrace();
            this.mensaje = "Error : " + e.getMessage();
        }
        FacesMessage mens = new FacesMessage(this.mensaje);
        FacesContext.getCurrentInstance().addMessage(null, mens);
    }

    public void eliminar(Tareas c) {
        try {
            this.juguete = c.getIdJuguete();
            this.juguete.setCantidad(c.getCantidad() + this.juguete.getCantidad());
            this.jugueteFacade.edit(this.juguete);
            this.tareasFacade.remove(c);
            this.tarea = new Tareas();
            this.mensaje = "Eliminado Con exito";
        } catch (Exception e) {
            e.printStackTrace();
            this.mensaje = "Error : " + e.getMessage();
        }
        FacesMessage mens = new FacesMessage(this.mensaje);
        FacesContext.getCurrentInstance().addMessage(null, mens);
    }

    public void limpiar() {
        this.tarea = new Tareas();
    }
}
