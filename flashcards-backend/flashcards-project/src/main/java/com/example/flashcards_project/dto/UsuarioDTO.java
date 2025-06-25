package com.example.flashcards_project.dto;

public record UsuarioDTO(long id, String nome, String matricula,    
                         String email,
                         String imagem,
                         String senha,
                         Double porcentagemAcertos, Double porcentagemErros) {
}
