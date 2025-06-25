package com.example.flashcards_project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.flashcards_project.entity.Sessao;
import com.example.flashcards_project.service.SessaoService;

@RestController
public class SessaoController {

    @Autowired
    private SessaoService sessaoService;

    @GetMapping("/sessao")
    public List<Sessao> getAllSessao() {
        return sessaoService.getAllSessoes(); // Placeholder response
    }

    @GetMapping("/sessao/{id}")
    public Sessao getSessaoById(Long id) {
        return sessaoService.getSessaoById(id); // Placeholder response
    }

    @GetMapping("/sessao/usuario/{usuarioId}")
    public List<Sessao> getSessoesByUsuarioId(Long usuarioId) {
        return sessaoService.getSessoesByUsuarioId(usuarioId); // Placeholder response
    }

    @PostMapping("/sessao")
    public Sessao createSessao(Sessao sessao) {
        sessaoService.saveSessao(sessao); // Placeholder response
        return sessao; // Return the created sessao
    }

    @PostMapping("/sessao/update")
    public Sessao updateSessao(Long id, Sessao newSessao) {
        sessaoService.updateSessao(id, newSessao); // Placeholder response
        return newSessao; // Return the updated sessao
    }

    @PostMapping("/sessao/delete/{id}")
    public void deleteSessao(Long id) {
        sessaoService.deleteSessaoById(id); // Placeholder response
    }

}
