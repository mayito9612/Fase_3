package org.bedu.java.backend.f3.Fase_3;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.bedu.java.backend.f3.Fase_3.controller.ClienteController;
import org.bedu.java.backend.f3.Fase_3.dto.cliente.ClienteDTO;
import org.bedu.java.backend.f3.Fase_3.dto.cliente.CrearClienteDTO;
import org.bedu.java.backend.f3.Fase_3.service.IClienteService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ClienteController.class)
@AutoConfigureRestDocs
public class ClienteControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private IClienteService clienteService;

    @Test
    @DisplayName("createCliente")
    void save() throws Exception {
        CrearClienteDTO crearClienteDTO = CrearClienteDTO.builder()
                .id(1L)
                .nombre("Mario Garza")
                .correoContacto("mario@gmail.com")
                .direccion("MTY")
                .build();

        ClienteDTO clienteDTO = ClienteDTO.builder()
                .id(2L)
                .nombre("Mario Garza")
                .correoContacto("mario@gmail.com")
                .direccion("MTY")
                .build();

        given(clienteService.save(crearClienteDTO)).willReturn(clienteDTO);
        assertEquals(clienteDTO.getId() ,2);
    }

    @Test
    @DisplayName("getClientes")
    void findAll() throws Exception {
        List<ClienteDTO> list = Arrays.asList(
                ClienteDTO.builder().id(1L).nombre("Nombre 1").correoContacto("correo1@gmail.com").direccion("Direccion 1").build(),
                ClienteDTO.builder().id(2L).nombre("Nombre 2").correoContacto("correo2@gmail.com").direccion("Direccion 2").build()
                );

        given(clienteService.findAll()).willReturn(list);
        assertEquals(list.size() ,2);

            }
    @Test
    @DisplayName("getCliente")
    void findById() throws Exception {
        given(clienteService.finById(anyLong())).willReturn(Optional.of(
                ClienteDTO.builder()
                        .id(1L)
                        .nombre("Juan")
                        .correoContacto("juan@gmail.com")
                        .direccion("Monterrey").build()));

        assertEquals(given(1),2);

    }
    @Test
    @DisplayName("updateCliente")
    void update() throws Exception{

        CrearClienteDTO createClienteDTO = CrearClienteDTO.builder()
                .id(2L)
                .nombre("Pedro")
                .correoContacto("pedro@gmail.com")
                .direccion("Toluca")
                .build();


        mockMvc.perform(RestDocumentationRequestBuilders.put("/clientes/{id}",2)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(createClienteDTO)))
                .andExpect(status().isNoContent());


    }
    @Test
    void delete() throws Exception {
        mockMvc.perform(RestDocumentationRequestBuilders.delete("/clientes/{id}", 1)
                        .content(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isNoContent());
    }

}
