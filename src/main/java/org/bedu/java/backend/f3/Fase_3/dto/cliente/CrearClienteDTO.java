package org.bedu.java.backend.f3.Fase_3.dto.cliente;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CrearClienteDTO {

    private long id;
    //@NotBlank(message = "El nombre debe ser obligatorio")
    private String nombre;
    //@Email
    private String correoContacto;
    //@NotBlank(message = "Se debe proporcionar una dirección")
    private String direccion;



}

