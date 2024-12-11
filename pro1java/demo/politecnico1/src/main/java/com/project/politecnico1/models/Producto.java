package com.project.politecnico1.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Entity
@Table(name = "productos")
public class Producto {
    
    @Id
    private int idProducto;
    
    @Column(name = "nombre")
    private String nombre;

    @Column(name = "valor")
    private double precio;

    private int cantidad;

}
