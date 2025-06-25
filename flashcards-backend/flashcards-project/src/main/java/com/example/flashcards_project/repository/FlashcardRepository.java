package com.example.flashcards_project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.flashcards_project.entity.Flashcard;

public interface FlashcardRepository extends JpaRepository<Flashcard, Long> {

    List<Flashcard> findByDeckId(Long deckId);

    List<Flashcard> findByDeckUsuarioId(Long usuarioId);

}
