package com.tests.mock.services;

import com.tests.mock.DTO.CategoriaDTO;
import com.tests.mock.entities.Categoria;
import com.tests.mock.mappers.CategoriaMapper;
import com.tests.mock.repositories.CategoriaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@AllArgsConstructor
public class CategoriaServiceImpl implements CategoriaService{

    private CategoriaRepository categoriaRepository;

    @Override
    public Set<CategoriaDTO> getCategorias() {
        return CategoriaMapper.INSTANCE
                .setCategoriaToCategoriaSet(
                        StreamSupport.stream(categoriaRepository.findAll().spliterator(), false)
                                .collect(Collectors.toSet()));
    }
}
