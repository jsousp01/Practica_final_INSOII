/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import EJB.PersonaFacadeLocal;
import EJB.UsuariosFacadeLocal;
import Entity.Persona;
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
public class PersonaController implements Serializable{
    
    @EJB
    private PersonaFacadeLocal personaFacade;
    @EJB
    private UsuariosFacadeLocal usuariosFacade;
    private List<Persona> listaPersona;
    private List<Usuarios> listaUsuarios;
    private Persona persona;
    String mensaje = "";

    public List<Persona> getListaPersona() {
        this.listaPersona = this.personaFacade.findAll();
        return listaPersona;
    }
    
        public List<Persona> getListaTrabajadores()  {
        this.listaUsuarios = this.personaFacade.findTrabajadores(2);
        this.listaPersona.clear();
        for(int i = 0; i < this.listaUsuarios.size(); i++) {
            this.listaPersona.add(this.listaUsuarios.get(i).getPersona());
        }
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
            List<Usuarios> lista = this.personaFacade.usuariosAsociados(c);
            Usuarios us;
            for (int i = 0; i < lista.size(); i++) {
                us = lista.get(i);
                this.usuariosFacade.remove(us);
            }
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
