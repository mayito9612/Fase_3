package org.bedu.java.backend.f3.Fase_3.service.impl;

import org.bedu.java.backend.f3.Fase_3.dto.cliente.ClienteDTO;
import org.bedu.java.backend.f3.Fase_3.dto.cliente.CrearClienteDTO;
import org.bedu.java.backend.f3.Fase_3.dto.cliente.UpdateClienteDTO;
import org.bedu.java.backend.f3.Fase_3.entity.Cliente;
import org.bedu.java.backend.f3.Fase_3.exception.GuestNotFoundException;
import org.bedu.java.backend.f3.Fase_3.mapper.IClienteMapper;
import org.bedu.java.backend.f3.Fase_3.repository.IClienteRepository;
import org.bedu.java.backend.f3.Fase_3.service.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClienteService implements IClienteService {
    private IClienteRepository repository;
    private IClienteMapper mapper;

    @Autowired
    public ClienteService(IClienteRepository repository, IClienteMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }
    public List<ClienteDTO> findALL() {
        List<Cliente> clientes = repository.findAll();
        return clientes.stream().map(mapper::toDTO).toList();
        /*return repository
                .findAll()
                .stream()
                .map(cliente -> mapper.toDTO(cliente))
                .collect(Collectors
                        .toList());*/
    }
    public Optional<ClienteDTO> finById(long id) {
        Optional<Cliente> cliente = repository.findById(id);
        return cliente.isPresent() ? Optional.of(mapper.toDTO(cliente.get())) : Optional.of(null);
    }
    public ClienteDTO save(CrearClienteDTO data) {
        Cliente entity = repository.save(mapper.toModel(data));
        return mapper.toDTO(entity);
    }
    public void update(long id, UpdateClienteDTO data){
        Optional<Cliente> actual = repository.findById(id);

        if (!actual.isPresent()){
            throw new GuestNotFoundException();
        }
        Cliente cliente = actual.get();
        mapper.toModel(cliente, data);
        repository.save(cliente);
    }
    public void delete(long id){
        repository.deleteById(id);
    }

    @Override
    public Object findAll() {
        return null;
    }
}
