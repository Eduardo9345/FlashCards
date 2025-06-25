package com.example.flashcards_project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.flashcards_project.entity.Estudo;
import com.example.flashcards_project.service.EstudoService;

@RestController
public class EstudoController {

    @Autowired
    private EstudoService estudoService;

    @GetMapping("/estudos")
    public List<Estudo> getAllEstudos() {
        return estudoService.getAllEstudos(); // Placeholder response
    }

    @GetMapping("/estudos/{id}")
    public Estudo getEstudoById(Long id) {
        return estudoService.getEstudoById(id); // Placeholder response
    }

    @GetMapping("/estudos/usuario/{usuarioId}")
    public List<Estudo> getEstudosByUsuarioId(Long usuarioId) {
        return estudoService.getEstudosByUsuarioId(usuarioId); // Placeholder response
    }

    @GetMapping("/estudos/deck/{deckId}")
    public List<Estudo> getEstudosByDeckId(Long deckId) {
        return estudoService.getEstudosByDeckId(deckId); // Placeholder response
    }
    
    @PostMapping("/estudos")
    public Estudo createEstudo(Estudo estudo) {
        estudoService.saveEstudo(estudo); // Placeholder response
        return estudo; // Return the created estudo
    }

    @PostMapping("/estudos/update")
    public Estudo updateEstudo(Long id, Estudo newEstudo) {
        estudoService.updateEstudo(id, newEstudo); // Placeholder response
        return newEstudo; // Return the updated estudo
    }

    @PostMapping("/estudos/delete/{id}")
    public void deleteEstudo(Long id) {
        estudoService.deleteEstudoById(id); // Placeholder response
    }
}
