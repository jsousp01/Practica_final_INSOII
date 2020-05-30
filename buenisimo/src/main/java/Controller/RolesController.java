/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import EJB.UsuariosFacadeLocal;
import Entity.Persona;
import Entity.Roles;
import Entity.Usuarios;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Anto
 */
@ManagedBean
@ViewScoped
public class RolesController implements Serializable{
    
    @EJB
    private UsuariosFacadeLocal usuarioFacade;
    private List<Usuarios> listaUsuarios;
    private Usuarios usuario;
    private Persona persona;
    private Roles rol;

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
}
