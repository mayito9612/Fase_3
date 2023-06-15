package org.bedu.java.backend.f3.Fase_3.dto.cliente;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
public class CrearClienteDTO {

    private long id;
    @NotBlank(message = "El nombre debe ser obligatorio")
    private String nombre;
    private String correoContacto;
    private String direccion;


}

