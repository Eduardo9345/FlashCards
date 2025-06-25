package com.example.flashcards_project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.flashcards_project.dto.DeckDTO;
import com.example.flashcards_project.entity.Deck;
import com.example.flashcards_project.service.DeckService;

@RestController
public class DeckController {


    @Autowired
    private DeckService deckService;

    @GetMapping("/decks")
    public List<Deck> getAllDecks() {
        return deckService.getAll(); // Placeholder response
    }

    @GetMapping("/decks/{id}")
    public Deck getDeckById(Long id) {
        return deckService.getDeckById(id); // Placeholder response
    }

    @GetMapping("/decks/usuario/{usuarioId}")
    public List<Deck> getDecksByUsuarioId(Long usuarioId) {
        return deckService.getDecksByUsuarioId(usuarioId); // Placeholder response
    }

    @PostMapping("/decks")
    public Deck createDeck(DeckDTO deck) {
        return deckService.save(deck); // Placeholder response
    }

    @PostMapping("/decks/update")
    public Deck updateDeck(DeckDTO deck) {
        return deckService.update(deck); // Placeholder response
    }

    @PostMapping("/decks/delete/{id}")
    public void deleteDeck(Long id) {
        deckService.delete(id); // Placeholder response
    }

}
