package com.example.flashcards_project.dto;

public record SessaoDTO(Long id,
                        String dataInicio,
                        String dataFim,
                        Integer acertos,
                        Integer erros,
                        Long usuarioId) {

}
