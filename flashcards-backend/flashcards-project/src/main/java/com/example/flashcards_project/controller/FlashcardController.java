package com.example.flashcards_project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.flashcards_project.dto.FlashcardDTO;
import com.example.flashcards_project.entity.Flashcard;
import com.example.flashcards_project.service.FlashcardService;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping
public class FlashcardController {

    @Autowired  
    private FlashcardService flashcardService;


    @GetMapping("/flashcards")
    public List<Flashcard> getAllFlashcards() {
        return flashcardService.getAllFlashcards(); // Placeholder response
    }
    
    @GetMapping("/flashcards/{id}")
    public Flashcard getFlashcardById(Long id) {
        return flashcardService.getFlashcardById(id); // Placeholder response
    }

    @GetMapping("/flashcards/deck/{deckId}")
    public List<Flashcard> getFlashcardsByDeckId(Long deckId) {
        return flashcardService.getFlashcardsByDeckId(deckId); // Placeholder response

    }

    @GetMapping("/flashcards/usuario/{usuarioId}")
    public List<Flashcard> getFlashcardsByUsuarioId(Long usuarioId) {
        return flashcardService.getFlashcardsByUsuarioId(usuarioId); // Placeholder response
    }

    @PostMapping("/flashcards")
    public Flashcard createFlashcard(FlashcardDTO flashcard) {
        return flashcardService.saveFlashcard(flashcard); // Placeholder response
    }

    @PostMapping("/flashcards/update")
    public Flashcard updateFlashcard(FlashcardDTO flashcard) {
        return flashcardService.updateFlashcard(flashcard); // Placeholder response
    }

    @PostMapping("/flashcards/delete/{id}")
    public void deleteFlashcard(Long id) {
        flashcardService.deleteFlashcardById(id); // Placeholder response
    }

}
