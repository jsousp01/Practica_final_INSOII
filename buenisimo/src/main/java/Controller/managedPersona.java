/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import EJB.PersonaFacadeLocal;
import Entity.Persona;
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
public class managedPersona implements Serializable{
    
    @EJB
    private PersonaFacadeLocal personaFacade;
    private List<Persona> listaPersona;
    private Persona persona;
    String mensaje = "";

    public List<Persona> getListaPersona() {
        this.listaPersona = this.personaFacade.findAll();
        return listaPersona;
    }

    public void setListaPersona(List<Persona> listaPersona) {
        this.listaPersona = listaPersona;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }
    
    @PostConstruct
    public void init() {
        this.persona = new Persona();
        
    }
    
    public void guardar(){
        try {
            this.personaFacade.create(persona);
            this.persona = new Persona();
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
            this.personaFacade.edit(persona);
            this.persona = new Persona();
            this.mensaje = "Actualizado Con exito";
        } catch (Exception e) {
            e.printStackTrace();
            this.mensaje = "Error : " + e.getMessage();
        }
        FacesMessage mens = new FacesMessage(this.mensaje);
        FacesContext.getCurrentInstance().addMessage(null, mens);
    }
    public void eliminar(Persona c){
        try {
            this.personaFacade.remove(c);
            this.persona = new Persona();
            this.mensaje = "Eliminado Con exito";
        } catch (Exception e) {
            e.printStackTrace();
            this.mensaje = "Error : " + e.getMessage();
        }
        FacesMessage mens = new FacesMessage(this.mensaje);
        FacesContext.getCurrentInstance().addMessage(null, mens);
    }
    public void cargarID(Persona c){
        this.persona = c;
    }
    public void limpiar(){
        this.persona = new Persona();
    }
    
}
