package com.nttdata.curso.crud.services;

import com.nttdata.curso.crud.entities.Client;
import com.nttdata.curso.crud.services.commons.CommonService;

public interface ClientService extends CommonService<Client> {
    public Client update(Long id, Client client);
}
