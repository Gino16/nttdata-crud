package com.nttdata.curso.crud.repositories;

import com.nttdata.curso.crud.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
