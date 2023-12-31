package org.bedu.java.backend.f3.Fase_3.dto.cliente;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClienteDTO {
    private long id;
    private String nombre;
    private String correoContacto;
    private String direccion;
}
