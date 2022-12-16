
package com.Proyecto01.domain;


import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="tours")
public class Tours implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private Long idTours;
    
    
    private String descripcion;
    private double precio;
    private int espacio;
    private boolean activo;

    public Tours(String descripcion, double precio, int espacio, boolean activo) {
        this.descripcion = descripcion;
        this.precio = precio;
        this.espacio = espacio;
        this.activo = activo;
    }
    
    
    public Tours() {
    }

   
    
    
}

