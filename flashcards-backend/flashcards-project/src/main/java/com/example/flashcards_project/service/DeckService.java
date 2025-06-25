package com.example.flashcards_project.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.flashcards_project.dto.DeckDTO;
import com.example.flashcards_project.entity.Deck;
import com.example.flashcards_project.repository.DeckRepository;

@Service
public class DeckService {

    @Autowired
    private DeckRepository deckRepository;

    @Autowired
    private UsuarioService usuarioService;

    public Deck save(DeckDTO deck) {
        Deck newDeck = new Deck();
        newDeck.setTitulo(deck.titulo());
        newDeck.setDescricao(deck.descricao());
        newDeck.setCategoria(deck.categoria());
        newDeck.setCriadoEm(LocalDate.parse(deck.criadoEm()));
        newDeck.setUsuario(usuarioService.getUsuarioById(deck.usuarioId()));

        return deckRepository.save(newDeck);
    }
    public Deck getDeckById(Long id) {
        return deckRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Deck not found"));
    }
    public List<Deck> getAll() {
        return deckRepository.findAll();
    }
    public void delete(Long id) {
        deckRepository.deleteById(id);
    }

    public Deck update(DeckDTO deck) {
        Deck existingDeck = getDeckById(deck.id());
        existingDeck.setTitulo(deck.titulo());
        existingDeck.setDescricao(deck.descricao());

        return deckRepository.save(existingDeck);
    }
    public List<Deck> getDecksByUsuarioId(Long usuarioId) {
        return deckRepository.findByUsuarioId(usuarioId);
    }

}
