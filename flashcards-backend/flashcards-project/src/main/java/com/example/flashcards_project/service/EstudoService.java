package com.example.flashcards_project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.flashcards_project.entity.Estudo;
import com.example.flashcards_project.repository.EstudoRepository;

@Service
public class EstudoService {

    @Autowired
    private EstudoRepository estudoRepository;

    public void saveEstudo(Estudo estudo) {
        estudoRepository.save(estudo);
    }

    public List<Estudo> getAllEstudos() {
        return estudoRepository.findAll();
    }

    public void deleteEstudoById(Long id) {
        estudoRepository.deleteById(id);
    }

    public Estudo getEstudoById(Long id) {
        return estudoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Estudo not found"));
    }
    public void updateEstudo(Long id, Estudo newEstudo) {
        estudoRepository.findById(id).ifPresent(estudo -> {
            estudo.setAcerto(newEstudo.getAcerto());
            estudo.setSessao(newEstudo.getSessao());
            estudo.setFlashcard(newEstudo.getFlashcard());
            estudo.setData(newEstudo.getData());
            estudoRepository.save(estudo);
        });
    }

    public List<Estudo> getEstudosByFlashcardId(Long flashcardId) {
        return estudoRepository.findByFlashcardId(flashcardId);
    }

    public List<Estudo> getEstudosByUsuarioId(Long usuarioId) {
        return estudoRepository.findByFlashcardDeckUsuarioId(usuarioId);
    }
    public List<Estudo> getEstudosByDeckId(Long deckId) {
        return estudoRepository.findByFlashcardDeckId(deckId);
    }
    
    
}
