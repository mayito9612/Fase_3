package org.bedu.java.backend.f3.Fase_3.mapper;

import org.bedu.java.backend.f3.Fase_3.dto.cliente.ClienteDTO;
import org.bedu.java.backend.f3.Fase_3.dto.cliente.CrearClienteDTO;
import org.bedu.java.backend.f3.Fase_3.dto.cliente.UpdateClienteDTO;
import org.bedu.java.backend.f3.Fase_3.entity.Cliente;
import org.mapstruct.*;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR, nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface IClienteMapper {

    ClienteDTO toDTO(Cliente data);

    Cliente toModel(CrearClienteDTO data);

    //@Mapping(target = "id", ignore = true)
    void toModel(@MappingTarget Cliente entity, UpdateClienteDTO data);
}
