package com.example.flashcards_project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.flashcards_project.entity.Materia;
import com.example.flashcards_project.service.MateriaService;

@RestController
public class MateriaController {

    @Autowired
    private MateriaService materiaService;

    @GetMapping("/materias")
    public List<Materia> getAllMaterias() {
        return materiaService.getAll(); // Placeholder response
    }

    @GetMapping("/materias/{id}")
    public Materia getMateriaById(Long id) {
        return materiaService.getMateriaById(id); // Placeholder response
    }


    @PostMapping("/materias")
    public Materia createMateria(Materia materia) {
        return materiaService.save(materia); // Placeholder response
    }

    @PostMapping("/materias/update")
    public Materia updateMateria(Materia materia) {
        return materiaService.update(materia); // Placeholder response
    }

    @PostMapping("/materias/delete/{id}")
    public void deleteMateria(Long id) {
        materiaService.delete(id); // Placeholder response
    }

    
}
