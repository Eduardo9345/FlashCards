package com.example.flashcards_project.dto;

public record EstudoDTO(Long id,
                        String data,
                        Boolean acerto,
                        Long flashcardId,
                        Long sessaoId) {

}
