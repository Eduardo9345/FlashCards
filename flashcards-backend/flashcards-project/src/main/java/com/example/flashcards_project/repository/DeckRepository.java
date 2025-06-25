package com.example.flashcards_project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.flashcards_project.entity.Deck;

public interface DeckRepository extends JpaRepository<Deck, Long>{

    List<Deck> findByUsuarioId(Long usuarioId);

}
