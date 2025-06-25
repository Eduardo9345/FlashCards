package com.example.flashcards_project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.flashcards_project.dto.FlashcardDTO;
import com.example.flashcards_project.entity.Dificuldade;
import com.example.flashcards_project.entity.Flashcard;
import com.example.flashcards_project.repository.FlashcardRepository;

@Service
public class FlashcardService {
    
    @Autowired
    private FlashcardRepository flashcardRepository;

    @Autowired
    private DeckService deckService; // Assuming you have a DeckService to handle deck-related operations

    @Autowired
    private MateriaService materiaService; // Assuming you have a MateriaService to handle materia-related operations

    
    
    public Flashcard saveFlashcard(FlashcardDTO flashcard) {
        Flashcard flashcardEntity = new Flashcard();
        flashcardEntity.setPergunta(flashcard.pergunta());
        flashcardEntity.setResposta(flashcard.resposta());
        flashcardEntity.setTags(flashcard.getTagsArray());

        flashcardEntity.setDificuldade(Dificuldade.valueOf(flashcard.dificuldade()));

        flashcardEntity.setDeck(deckService.getDeckById(flashcard.deckId()));

        flashcardEntity.setMateria(materiaService.getMateriaById(flashcard.materiaId()));

        return flashcardRepository.save(flashcardEntity);
    }
    
    public List<Flashcard> getAllFlashcards() {
        return flashcardRepository.findAll();
    }
    
    public List<Flashcard> getFlashcardsByDeckId(Long deckId) {
        return flashcardRepository.findByDeckId(deckId);
    }
    
    public List<Flashcard> getFlashcardsByUsuarioId(Long usuarioId) {
        return flashcardRepository.findByDeckUsuarioId(usuarioId);
    }
    
    public void deleteFlashcardById(Long id) {
        flashcardRepository.deleteById(id);
    }


    public Flashcard updateFlashcard(FlashcardDTO flashcard) {
        Flashcard entity = getFlashcardById(flashcard.id());
        entity.setMateria(materiaService.getMateriaById(flashcard.materiaId()));
        entity.setDeck(deckService.getDeckById(flashcard.deckId()));
        entity.setPergunta(flashcard.pergunta());
        entity.setResposta(flashcard.resposta());
        entity.setDificuldade(Dificuldade.valueOf(flashcard.dificuldade()));
        entity.setTags(flashcard.getTagsArray());

        return flashcardRepository.save(entity);
    }

    public void updateFlashcard(Long id, String newFront, String newBack) {
        flashcardRepository.findById(id).ifPresent(flashcard -> {
            flashcard.setPergunta(newBack);
            flashcard.setResposta(newBack);
            flashcardRepository.save(flashcard);
        });
    }

    public void updateFlashcardDeck(Long id, Long newDeckId) {
        flashcardRepository.findById(id).ifPresent(flashcard -> {

            flashcard.setDeck(deckService.getDeckById(newDeckId));
            flashcardRepository.save(flashcard);
        });
    }


    public Flashcard getFlashcardById(Long id) {
        return flashcardRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Flashcard not found"));
    }


    public void deleteFlashcard(Flashcard flashcard) {
        flashcardRepository.delete(flashcard);
    }
    

    
}
