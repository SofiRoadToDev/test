package com.tests.mock.services;

import com.tests.mock.DTO.CategoriaDTO;
import com.tests.mock.entities.Categoria;

import java.util.Set;

public interface CategoriaService {


    Set<CategoriaDTO> getCategorias();
}
