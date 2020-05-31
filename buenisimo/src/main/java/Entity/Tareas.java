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
    @JoinColumn(name="IdJuguete")
    @ManyToOne
    private Juguete idJuguete;
    @Column(name = "Cantidad")
    private int cantidad;
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

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Juguete getIdJuguete() {
        return idJuguete;
    }

    public void setIdJuguete(Juguete idJuguete) {
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
