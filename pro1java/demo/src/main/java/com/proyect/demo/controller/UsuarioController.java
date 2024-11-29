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

import com.proyect.demo.models.Usuario;

@RestController
public class UsuarioController {
   private List<Usuario> usuarios = new ArrayList<>(
        Arrays.asList(new Usuario(123, "Oscarina", "Romero"))
    );

@GetMapping("/usuarios")
public List<Usuario> getUsuarios() {
    return usuarios;
}

@GetMapping("/{nombre}")
public Usuario getuserid(@PathVariable String nombre) {
    for (Usuario c : usuarios) {
        if (c.getNombre().equalsIgnoreCase(nombre)){
            return c;
        }
    }
    return null;
}

@PostMapping("/usuario")
public Usuario creUsuario(@RequestBody Usuario usuario) {
    usuarios.add(usuario);    
    return usuario;
}

@PutMapping("/usuario")
public Usuario putUsuario(@RequestBody Usuario usuario) {
    for(Usuario u : usuarios)
       if (u.getIdUser()==usuario.getIdUser()) {
           u.setNombre(usuario.getNombre());
           u.setApellido(usuario.getApellido());
           return u;
        
       }
    
    return null;
}

@DeleteMapping("/{idUser}")
public Usuario eliminarUsuario(@PathVariable int idUser){
    for (Usuario u : usuarios){
        if (u.getIdUser() == idUser) {
            usuarios.remove(u);
            return u;
        }
    }
    return null;
}
}
