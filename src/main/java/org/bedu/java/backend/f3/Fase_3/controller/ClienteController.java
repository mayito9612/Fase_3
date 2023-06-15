package org.bedu.java.backend.f3.Fase_3.controller;

import org.bedu.java.backend.f3.Fase_3.dto.cliente.ClienteDTO;
import org.bedu.java.backend.f3.Fase_3.dto.cliente.CrearClienteDTO;
import org.bedu.java.backend.f3.Fase_3.service.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("clientes")
public class ClienteController {

    private IClienteService service;

    @Autowired
    public ClienteController(IClienteService service) {
        this.service = service;
    }
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ClienteDTO> finAll(){
        return service.findALL();
    }
    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<ClienteDTO> finById(@PathVariable("id") long id){
        return service.finById(id);
    }
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public ClienteDTO save(@RequestBody CrearClienteDTO data){
        return service.save(data);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") long id){
        service.delete(id);
    }
}
