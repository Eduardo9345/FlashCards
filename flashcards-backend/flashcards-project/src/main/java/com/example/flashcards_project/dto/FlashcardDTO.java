package com.example.flashcards_project.dto;

import java.util.Set;
import java.util.Arrays;
import java.util.stream.Collectors;

public record FlashcardDTO(Long id, 
                           String pergunta, 
                           String resposta, 
                           String tags, 
                           String dificuldade, 
                           Long deckId, 
                           Long materiaId, Long usuarioId) {
    
    // You can add additional methods or validations if needed
        
    public Set<String> getTagsArray() {
        return Arrays.stream(tags.split(","))
                     .map(String::trim)
                     .collect(Collectors.toSet());
    }

}
