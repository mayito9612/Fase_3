package org.bedu.java.backend.f3.Fase_3.dto.cliente;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UpdateClienteDTO {
    private long id;
    private String nombre;
    private String correoContacto;
    private String direccion;
}
