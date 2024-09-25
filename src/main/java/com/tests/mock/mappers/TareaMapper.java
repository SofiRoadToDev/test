package com.tests.mock.mappers;

import com.tests.mock.DTO.CategoriaDTO;
import com.tests.mock.DTO.TareaDTO;
import com.tests.mock.entities.Categoria;
import com.tests.mock.entities.Tarea;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.Set;

@Mapper(componentModel = "spring", uses = {CategoriaMapper.class})
public interface TareaMapper {

    TareaMapper INSTANCE = Mappers.getMapper(TareaMapper.class);

    @Mapping(source = "detalle", target = "descripcion")
    @Mapping(source = "categoria", target = "categoria.nombre")
    Tarea tareaDtoToTarea(TareaDTO tareaDTO);

    @Mapping(source = "descripcion", target = "detalle")
    @Mapping(source = "categoria.nombre", target = "categoria")
    TareaDTO tareaDtoToTarea(Tarea tarea);

    Set<Tarea>setTareaDtoToSetTarea(Set<TareaDTO> tareaDTOSet);
    Set<TareaDTO>setTareaToSetTareaDto(Set<Tarea>tareaSet);





}
