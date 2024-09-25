package com.tests.mock.DTO;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

import java.util.HashSet;
import java.util.Set;

@Data
@Builder
@AllArgsConstructor
public class CategoriaDTO {

    private Long id;

    @NonNull @NotBlank(message = "el nombre de la categoria es obligatorio")
    private String nombre;

    private Set<TareaDTO> tareas = new HashSet<>();
}
