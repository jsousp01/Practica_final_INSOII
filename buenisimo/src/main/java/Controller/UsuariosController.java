/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import EJB.PersonaFacadeLocal;
import EJB.UsuariosFacadeLocal;
import Entity.Persona;
import Entity.Roles;
import Entity.Usuarios;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

/**
 *
 * @author Anto
 */
@ManagedBean
@ViewScoped
public class UsuariosController implements Serializable {

    ExternalContext contexto;         
    @EJB
    private UsuariosFacadeLocal usuarioFacade;
    @EJB
    private PersonaFacadeLocal personaFacade;
    private List<Usuarios> listaUsuarios;
    private Usuarios usuario;
    private Persona persona;
    private Roles rol;
    private String mensaje="";

    public List<Usuarios> getListaUsuarios() {
        this.listaUsuarios = this.usuarioFacade.findAll();
        return listaUsuarios;
    }

    public void setListaUsuarios(List<Usuarios> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }

    public Usuarios getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuarios usuario) {
        this.usuario = usuario;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Roles getRol() {
        return rol;
    }

    public void setRol(Roles rol) {
        this.rol = rol;
    }

    @PostConstruct
    public void init() {
        this.persona = new Persona();
        this.rol = new Roles();
        this.usuario = new Usuarios();
    }

    public void guardar() {
        try {
            this.usuario.setPersona(persona);
            this.personaFacade.create(persona);
            this.usuario.setRol(rol);
            this.usuarioFacade.create(usuario);
            this.usuario = new Usuarios();
            this.mensaje = "Almacenado Con exito";
        } catch (Exception e) {
            e.printStackTrace();
            this.mensaje = "Error : " + e.getMessage();
        }
        FacesMessage mens = new FacesMessage(this.mensaje);
        FacesContext.getCurrentInstance().addMessage(null, mens);
    }

    public String validar() {
        String ruta = "";
        Usuarios login;
        login = this.usuarioFacade.verificarUsuario(this.usuario);
        if (login != null) {
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario", login);
            if (login.getRol().getTipoUsuario() == 'T') {
                ruta = "privado/trabajador/vistaTrabajador";
            } else if (login.getRol().getTipoUsuario() == 'A') {
                ruta = "privado/admin/vistaAdmin";
            } else {
                ruta = "error";
            }
        } else {
            ruta = "error";
        }
        return ruta;
    }
    
        public void cargarID(Usuarios c){
        this.usuario.setPersona(persona);
        this.usuario = c;
    }

    public String nombre() {
        Usuarios uy = (Usuarios) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
        return (uy.getPersona().getNombre() + " " +uy.getPersona().getApellido1() + " " +uy.getPersona().getApellido2());
    }
}
