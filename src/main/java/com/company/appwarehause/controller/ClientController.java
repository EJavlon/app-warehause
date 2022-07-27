package com.company.appwarehause.controller;

import com.company.appwarehause.entity.Client;
import com.company.appwarehause.payload.Result;
import com.company.appwarehause.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/client")
public class ClientController {
    @Autowired
    private ClientService clientService;

    @GetMapping("/{id}")
    public Result getClient(@PathVariable Integer id){
        return clientService.getClient(id);
    }

    @GetMapping
    public Page<Client> getClients(@RequestParam int page){
        return clientService.getClients(page);
    }

    @PostMapping
    public Result addClient(@RequestBody Client client){
        return clientService.addClient(client);
    }

    @PutMapping("/{id}")
    public Result editClient(@PathVariable Integer id, @RequestBody Client client){
        return clientService.editClient(id,client);
    }

    @DeleteMapping("/{id}")
    public Result deleteClient(@PathVariable Integer id){
        return clientService.deleteClient(id);
    }
}
