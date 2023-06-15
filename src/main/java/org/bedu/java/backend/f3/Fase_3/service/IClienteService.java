package org.bedu.java.backend.f3.Fase_3.service;

import org.bedu.java.backend.f3.Fase_3.dto.cliente.ClienteDTO;
import org.bedu.java.backend.f3.Fase_3.dto.cliente.CrearClienteDTO;

import java.util.List;
import java.util.Optional;

public interface IClienteService{
    List<ClienteDTO> findALL();
    Optional<ClienteDTO> finById(long id);

    ClienteDTO save(CrearClienteDTO data);
    //void update(long id, UpdateGuestDTO data);

    void delete(long id);

}
