package com.tests.mock.services;

import com.tests.mock.DTO.TareaDTO;
import com.tests.mock.entities.Tarea;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;


@Service
public interface TareaService {

    Set<TareaDTO>findAll();
    TareaDTO findById(Long id);
    Set<TareaDTO> findByCategoria(String categoria);
    TareaDTO crearTarea(TareaDTO tareaDTO);
    TareaDTO actualizarTarea(TareaDTO tareaDTO);
    void borrarTarea(Long id);


}
