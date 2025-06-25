package com.example.flashcards_project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.flashcards_project.entity.Estudo;

public interface EstudoRepository extends JpaRepository<Estudo, Long>{

    List<Estudo> findByFlashcardId(Long flashcardId);

    List<Estudo> findByFlashcardDeckUsuarioId(Long usuarioId);

    List<Estudo> findByFlashcardDeckId(Long deckId);

}
