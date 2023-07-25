package com.example.crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.crud.models.Tarea;
import com.example.crud.repositories.TareaRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tareas")
public class TareaController {

    @Autowired
    private TareaRepository tareaRepository;

    @GetMapping
    public List<Tarea> getAllTareas() {
        return tareaRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Tarea> getTareaById(@PathVariable Long id) {
        return tareaRepository.findById(id);
    }

    @PostMapping
    public Tarea createTarea(@RequestBody Tarea tarea) {
        return tareaRepository.save(tarea);
    }

    @PutMapping("/{id}")
    public Tarea updateTarea(@PathVariable Long id, @RequestBody Tarea updatedTarea) {
        Optional<Tarea> tarea = tareaRepository.findById(id);
        if (tarea.isPresent()) {
            Tarea tareaToUpdate = tarea.get();
            tareaToUpdate.setName(updatedTarea.getName());
            tareaToUpdate.setDueDate(updatedTarea.getDueDate());
            tareaToUpdate.setPriority(updatedTarea.getPriority());
            tareaToUpdate.setStatus(updatedTarea.getStatus());
            tareaToUpdate.setAssigned(updatedTarea.getAssigned());
            return tareaRepository.save(tareaToUpdate);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteTarea(@PathVariable Long id) {
        tareaRepository.deleteById(id);
    }
}
