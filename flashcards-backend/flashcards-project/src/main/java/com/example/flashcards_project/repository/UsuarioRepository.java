package com.example.flashcards_project.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.flashcards_project.entity.Usuario;

public interface UsuarioRepository extends JpaRepository <Usuario, Long>{

    Optional<Usuario> findByEmail(String email);

    Optional<Usuario> findByMatricula(String matricula);

}
