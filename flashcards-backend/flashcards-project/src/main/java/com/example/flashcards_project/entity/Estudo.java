package com.example.flashcards_project.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
public class Estudo {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @DateTimeFormat
    private LocalDateTime data;

    @Column
    private Boolean acerto;

    @ManyToOne
    @JoinColumn(name = "flashcard_id", referencedColumnName = "id", nullable = false)
    @OnDelete(action = OnDeleteAction.SET_NULL)
    private Flashcard flashcard;

    @ManyToOne(fetch = FetchType.LAZY) // Carregamento sob demanda
    @JoinColumn(name = "sessao_id", nullable = false)
    private Sessao sessao;
}
