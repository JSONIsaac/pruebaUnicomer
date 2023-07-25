package com.example.crud.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.crud.models.Tarea;

@Repository
public interface TareaRepository extends JpaRepository<Tarea, Long> {
}
