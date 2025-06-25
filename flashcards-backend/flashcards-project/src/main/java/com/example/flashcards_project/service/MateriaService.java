package com.example.flashcards_project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.flashcards_project.entity.Materia;
import com.example.flashcards_project.repository.MateriaRepository;

@Service
public class MateriaService {

    @Autowired
    private MateriaRepository materiaRepository;
    
    public Materia save(Materia materia) {
        return materiaRepository.save(materia);
    }

    public Materia getMateriaById(Long id) {
        return materiaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Materia not found"));
    }

    public void delete(Long id) {
        materiaRepository.deleteById(id);
    }

    public Materia update(Materia materia) {
        Materia existingMateria = getMateriaById(materia.getId());
        existingMateria.setTitulo(materia.getTitulo());
        return materiaRepository.save(existingMateria);
    }

    public List<Materia> getAll() {
        return materiaRepository.findAll();
    }
    
}
