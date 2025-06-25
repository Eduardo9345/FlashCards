package com.example.flashcards_project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.flashcards_project.entity.Sessao;

public interface SessaoRepository extends JpaRepository <Sessao, Long> {

    List<Sessao> findByUsuarioId(Long usuarioId);

}
