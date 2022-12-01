package com.Proyecto01.domain;

import java.io.Serializable;
import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "cliente")

public class Cliente implements Serializable {

    private static final long seralVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name="id_cliente")
    private Long idCliente;

    //Atributos
    private String nombre;
    private String apellido;
    private String correo;
    private String telefono;
    
    
 
    
    
    //Contructor
    public Cliente(String nombre, String apellido, String correo, String telefono) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.telefono = telefono;
    }

    public Cliente() {
    }

    
    
    

}
