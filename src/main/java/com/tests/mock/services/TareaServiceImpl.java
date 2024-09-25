package com.tests.mock.services;

import com.tests.mock.DTO.TareaDTO;
import com.tests.mock.entities.Categoria;
import com.tests.mock.entities.Tarea;
import com.tests.mock.esceptions.ElementNotFoundException;
import com.tests.mock.mappers.TareaMapper;
import com.tests.mock.repositories.CategoriaRepository;
import com.tests.mock.repositories.TareaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@AllArgsConstructor
public class TareaServiceImpl implements TareaService{

    private TareaRepository tareaRepository;
    private CategoriaRepository categoriaRepository;

    @Override
    public Set<TareaDTO> findAll() {
        return TareaMapper.INSTANCE.setTareaToSetTareaDto(StreamSupport.stream(tareaRepository.findAll().spliterator(),false).collect(Collectors.toSet()));
    }

    @Override
    public TareaDTO findById(Long id) throws ElementNotFoundException {
        Tarea tarea = tareaRepository.findById(id)
                .orElseThrow(() -> new ElementNotFoundException("Tarea id: "+id+" no encontrada"));
        return TareaMapper.INSTANCE.tareaDtoToTarea(tarea);
    }

    @Override
    public Set<TareaDTO> findByCategoria(String categoria) {

        return TareaMapper.INSTANCE.setTareaToSetTareaDto(tareaRepository.findByCategoriaNombre(categoria));
    }

    @Override
    public TareaDTO crearTarea(TareaDTO tareaDTO) {
        Optional<Categoria> categoriaExistente = categoriaRepository.findByNombre(tareaDTO.getCategoria());
        Tarea tarea = TareaMapper.INSTANCE.tareaDtoToTarea(tareaDTO);
        tarea.setCategoria(categoriaExistente.get());
        return TareaMapper.INSTANCE.tareaDtoToTarea(tareaRepository.save(tarea));
    }

    @Override
    public TareaDTO actualizarTarea(TareaDTO tareaDTO) {
        Optional<Categoria> categoriaExistente = categoriaRepository.findByNombre(tareaDTO.getCategoria());
        Tarea tarea = TareaMapper.INSTANCE.tareaDtoToTarea(tareaDTO);
            tarea.setCategoria(categoriaExistente.get());
        return TareaMapper.INSTANCE.tareaDtoToTarea(tareaRepository.save(tarea));

    }

    @Override
    public void borrarTarea(Long id) throws ElementNotFoundException{
        Tarea tarea = tareaRepository.findById(id)
                .orElseThrow(() -> new ElementNotFoundException("La tarea id: "+id+ " no existe"));
        tareaRepository.delete(tarea);
    }
}
