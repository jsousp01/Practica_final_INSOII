/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import EJB.UsuariosFacadeLocal;
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
public class managedUsuarios implements Serializable {
    
    @EJB
    private UsuariosFacadeLocal usuariosFacade;
    private List<Usuarios> listaUsuarios;
    private Usuarios usuario;

    public List<Usuarios> getListaUsuarios() {
        this.listaUsuarios = this.usuariosFacade.findAll();
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
    
    @PostConstruct
    public void init() {
        this.usuario = new Usuarios(); 
    }
    
    public String validar(){
        String ruta = "";
        Usuarios login;
        login = this.usuariosFacade.verificarUsuario(this.usuario);
           if(login != null) {
               ruta = "privado/trabajador/vistaTrabajador";
           } else {
               ruta = "error";
           }
    return ruta;
    }
    
}
