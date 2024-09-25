package com.tests.mock.DTO;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;
import org.hibernate.validator.constraints.Length;
import org.mapstruct.Mapper;

@Data
@Builder
@AllArgsConstructor
public class TareaDTO {

    private Long id;
    @NonNull @NotBlank(message = "El nombre no puede quedar vacío") @Length(min = 1, max = 50, message = "El máximo de caracteres es 50")
    private String nombre;
    @Length(min = 1, max = 100, message = "El maximo de caracteres es 100")
    private String detalle;
    private String categoria;

}
