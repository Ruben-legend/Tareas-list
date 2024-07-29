package com.api.tarea.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.tarea.models.Tarea;

@Repository
public interface TareaRepository extends JpaRepository<Tarea, Integer> {
}
