package com.tests.mock.repositories;

import com.tests.mock.entities.Tarea;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface TareaRepository extends CrudRepository<Tarea,Long> {
    Set<Tarea> findByCategoriaNombre(String nombre);
}
