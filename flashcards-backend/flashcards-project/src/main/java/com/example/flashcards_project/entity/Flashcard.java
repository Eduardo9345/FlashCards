package com.example.flashcards_project.entity;

import java.util.Set;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Flashcard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String pergunta;

    @Column
    private String resposta;

    @Column
    private Set<String> tags;

    @Enumerated
    private Dificuldade dificuldade;

    @ManyToOne(fetch = FetchType.LAZY) // Carregamento sob demanda
    @JoinColumn(name = "deck_id", nullable = false)
    private Deck deck;

    @ManyToOne
    @JoinColumn(name = "materia_id", referencedColumnName = "id", nullable = false)
    @OnDelete(action = OnDeleteAction.SET_NULL)
    private Materia materia;
}
