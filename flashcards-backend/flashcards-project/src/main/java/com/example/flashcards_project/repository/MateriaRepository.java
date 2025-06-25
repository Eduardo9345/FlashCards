package com.example.flashcards_project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.flashcards_project.entity.Materia;

public interface MateriaRepository extends JpaRepository <Materia, Long> {


}
