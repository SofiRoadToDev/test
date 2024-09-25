package com.tests.mock.repositories;

import com.tests.mock.entities.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CategoriaRepository extends CrudRepository<Categoria,Long> {
    Optional<Categoria>findByNombre(String nombre);
}
