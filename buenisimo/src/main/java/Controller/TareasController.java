/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import EJB.TareasFacadeLocal;
import Entity.Tareas;
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
    String mensaje = "";

    public List<Tareas> getListaTareas() {
        this.listaTareas = this.tareasFacade.findAll();
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
    
    
    @PostConstruct
    public void init() {
        this.tarea = new Tareas();
    }
    
        public void eliminar(Tareas c){
        try {
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
}