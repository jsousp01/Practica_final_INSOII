/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 *
 * @author Anto
 */
@Entity
@Table(name = "tareas")
public class Tareas implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTarea;
    @Column(name = "IdJuguete")
    private String idJuguete;
    @Column(name = "NombreJuguete")
    private String nombreJuguete;

    @Column(name = "Cantidad")
    private String cantidad;
    @JoinColumn(name = "IdPersona")
    @ManyToOne
    private Persona persona;

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public int getIdTarea() {
        return idTarea;
    }

    public void setIdTarea(int idTarea) {
        this.idTarea = idTarea;
    }

    public String getNombreJuguete() {
        return nombreJuguete;
    }

    public void setNombreJuguete(String nombreJuguete) {
        this.nombreJuguete = nombreJuguete;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public String getIdJuguete() {
        return idJuguete;
    }

    public void setIdJuguete(String idJuguete) {
        this.idJuguete = idJuguete;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 41 * hash + this.idTarea;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Tareas other = (Tareas) obj;
        if (this.idTarea != other.idTarea) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Tareas{" + "idTarea=" + idTarea + '}';
    }

}
