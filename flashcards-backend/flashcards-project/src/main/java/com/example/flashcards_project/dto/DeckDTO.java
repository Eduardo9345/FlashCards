package com.example.flashcards_project.dto;

public record DeckDTO(Long id, 
                    String titulo, 
                    String descricao, 
                    String categoria,
                    String criadoEm,
                    Long usuarioId) {

}
