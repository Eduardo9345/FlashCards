package com.example.flashcards_project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.flashcards_project.dto.UsuarioDTO;
import com.example.flashcards_project.entity.Usuario;
import com.example.flashcards_project.service.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/get")
    public Usuario getUsuario(@RequestBody Long id) {
        return usuarioService.getUsuarioById(id); // Example ID, replace with actual logic
    }

    @GetMapping("/all")
    public List<Usuario> getAllUsuarios() {
        return usuarioService.getAll();
    }

    @GetMapping("/byEmail")
    public Usuario getUsuarioByEmail(@RequestBody String email) {
        return usuarioService.getUsuarioByEmail(email);
    }
    
    @GetMapping("/byMatricula")
    public Usuario getUsuarioByMatricula(@RequestBody String matricula) {
        return usuarioService.getUsuarioByMatricula(matricula);
    }

    @PostMapping("/save")
    public Usuario saveUsuario(@RequestBody UsuarioDTO usuario) {

        return usuarioService.save(usuario);
    }

    @PutMapping("/update")
    public Usuario updateUsuario(@RequestBody UsuarioDTO usuario) {
        
        return usuarioService.update(usuario);
    }

    @DeleteMapping
    public void deleteUsuario(@RequestBody Long id) {
        usuarioService.delete(id);
    }

    @GetMapping("/existsByEmail")
    public boolean existsByEmail(@RequestBody String email) {
        return usuarioService.existsByEmail(email);
    }

    @GetMapping("/existsByMatricula")
    public boolean existsByMatricula(@RequestBody String matricula) {
        return usuarioService.existsByMatricula(matricula);
    }
    

    @PostMapping("/addDeck")
    public boolean addDeckToUsuario(@RequestBody Long id, @RequestBody Long deckId) {
        return usuarioService.addDeckToUsuario(id, deckId);
    }

    @PostMapping("/removeDeck")
    public boolean removeDeckFromUsuario(@RequestBody Long id, @RequestBody Long deckId) {
        return usuarioService.removeDeckFromUsuario(id, deckId);
    }


}
