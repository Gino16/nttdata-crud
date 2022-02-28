package com.nttdata.curso.crud.services.imp;

import com.nttdata.curso.crud.entities.Client;
import com.nttdata.curso.crud.repositories.ClientRepository;
import com.nttdata.curso.crud.services.ClientService;
import com.nttdata.curso.crud.services.commons.CommonServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceImpl extends CommonServiceImpl<Client, ClientRepository> implements ClientService {

    @Override
    public Client update(Long id, Client client){
        Client clientUpdated = this.findOneById(id);
        clientUpdated.setDocumentNumber(client.getDocumentNumber());
        clientUpdated.setName(client.getName());
        clientUpdated.setLastname(client.getLastname());
        clientUpdated.setBirthday(client.getBirthday());
        return repository.save(clientUpdated);
    }
}
