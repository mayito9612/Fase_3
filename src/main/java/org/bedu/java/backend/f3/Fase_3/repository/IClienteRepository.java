package org.bedu.java.backend.f3.Fase_3.repository;

import org.bedu.java.backend.f3.Fase_3.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IClienteRepository extends JpaRepository<Cliente, Long> {
}
