package com.tests.mock.mappers;

import com.tests.mock.DTO.CategoriaDTO;
import com.tests.mock.DTO.SimpleTareaDto;
import com.tests.mock.entities.Categoria;
import com.tests.mock.entities.Tarea;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {TareaMapper.class})
public interface CategoriaMapper {

    CategoriaMapper INSTANCE = Mappers.getMapper(CategoriaMapper.class);


    @Mapping(target = "tareas.categoria", ignore = true)
    Categoria categoriaDtoToCategoria(CategoriaDTO categoriaDTO);

    @Mapping(target = "tareas", ignore = true )
    CategoriaDTO categoriaToCategoriaDto(Categoria categoria);




}
