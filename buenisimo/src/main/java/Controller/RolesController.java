/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import EJB.RolesFacadeLocal;
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
    private RolesFacadeLocal rolEJB;
    private List<Roles> listaRoles;
    private Roles rol;

    public Roles getRol() {
        return rol;
    }

    public void setRol(Roles rol) {
        this.rol = rol;
    }

    public List<Roles> getListaRoles() {
        this.listaRoles = this.rolEJB.findAll();
        return listaRoles;
    }

    public void setListaRoles(List<Roles> listaRoles) {
        this.listaRoles = listaRoles;
    }
    
    @PostConstruct
    public void init() {
        this.rol = new Roles();
    }
}
