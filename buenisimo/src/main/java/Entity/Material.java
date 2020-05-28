/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Jose
 */
@Entity
@Table(name = "material")
public class Material implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idMaterial;
    @Column(name = "Nombre")
    private String nombre;
    @Column(name = "Cantidad")
    private int cantidad;
    @JoinColumn(name="IdJuguete")
    @ManyToOne(cascade=CascadeType.PERSIST)
    private Juguete idJuguete;

    public int getIdMaterial() {
        return idMaterial;
    }

    public void setIdMaterial(int idMaterial) {
        this.idMaterial = idMaterial;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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
        hash = 29 * hash + this.idMaterial;
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
        final Material other = (Material) obj;
        if (this.idMaterial != other.idMaterial) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Material{" + "idMaterial=" + idMaterial + '}';
    }
    
}
