package com.proyect.demo.models;

import lombok.AllArgsConstructor;
import lombok.Data;
@Data
@AllArgsConstructor
public class Producto {
    private Integer idProducto;
    private String nombre;
    private Integer valor;
    private Integer cantidad;
}
