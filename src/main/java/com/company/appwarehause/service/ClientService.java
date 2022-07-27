package com.company.appwarehause.service;

import com.company.appwarehause.entity.Client;
import com.company.appwarehause.payload.Result;
import com.company.appwarehause.repasitory.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;

    public Result getClient(Integer id) {
        Optional<Client> optionalClient = clientRepository.findById(id);
        if (!optionalClient.isPresent()) return new Result("Client not found",false);

        return new Result("Client found",true,optionalClient.get());
    }

    public Page<Client> getClients(int page) {
        Pageable pageable = PageRequest.of(page,10);
        return clientRepository.findAll(pageable);
    }

    public Result addClient(Client client) {
        boolean exists = clientRepository.existsByNameAndPhoneNumber(client.getName(), client.getPhoneNumber());
        if (exists) return new Result("There is such a client",false);

        clientRepository.save(client);
        return new Result("Client seccessfully added",true);
    }

    public Result editClient(Integer id, Client client) {
        Optional<Client> optionalClient = clientRepository.findById(id);
        if (!optionalClient.isPresent()) return new Result("Client not found",false);

        boolean exists = clientRepository.existsByNameAndPhoneNumber(client.getName(), client.getPhoneNumber());
        if (exists) return new Result("There is such a client",false);

        Client editedClient = optionalClient.get();
        editedClient.setName(client.getName());
        editedClient.setPhoneNumber(client.getPhoneNumber());
        clientRepository.save(editedClient);

        return new Result("Client seccessfully edited",true);
    }

    public Result deleteClient(Integer id) {
        Optional<Client> optionalClient = clientRepository.findById(id);
        if (!optionalClient.isPresent()) return new Result("Client not found",false);

        clientRepository.deleteById(id);
        return new Result("Client seccessfully deleted",true);
    }
}
