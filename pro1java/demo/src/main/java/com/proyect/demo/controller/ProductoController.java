package com.proyect.demo.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.proyect.demo.models.Producto;

@RestController
public class ProductoController {

    
    private List<Producto> productos = new ArrayList<>(
      Arrays.asList(new Producto(123, "Yogurt", 12000, 10))
);

@GetMapping("/productos")
public List<Producto> getProductos() {
     return productos;
}

@GetMapping("/{nombre}")
public Producto getProductId(@PathVariable String nombre) {
     for (Producto c : productos) {
        if (c.getNombre().equalsIgnoreCase(nombre))
{
        return c;
        }
      }
      return null;
}

@PostMapping("/producto")
public Producto creProducto(@RequestBody Producto producto) {
     productos.add(producto);
     return producto;
}

@PutMapping("/producto")
public Producto
putProducto(@RequestBody Producto producto) {
         for(Producto p : productos)
             if (p.getIdProducto()==producto.getIdProducto()) {
p.setNombre(producto.getNombre());
p.setValor(producto.getValor());
p.setCantidad(producto.getCantidad());
     return p;
             }
    return null;
}

@DeleteMapping("/{idUser}")
public Producto eliminarProductoxd(@PathVariable int idProducto){
    for (Producto p : productos){
        if (p.getIdProducto() == idProducto) {
            productos.remove(p);
            return p;
        }
    }
    return null;
}
}

