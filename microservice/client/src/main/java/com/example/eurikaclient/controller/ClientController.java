package com.example.eurikaclient.controller;

import com.example.eurikaclient.entity.Client;
import com.example.eurikaclient.service.Clientservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ClientController {

    @Autowired
    private Clientservice clientservice;
    @GetMapping("/clients")
    public List<Client> findAll() {
        return clientservice.findAll();
    }
    @GetMapping("/{id}")
    public Optional<Client> findById(@PathVariable Long id) {
        return clientservice.findById(id);
    }

    @PostMapping("/")
    public Client save(@RequestBody Client client) {
        return clientservice.save(client);
    }

    @DeleteMapping("/id/{id}")
    public void deleteById(@PathVariable Long id) {
        clientservice.deleteById(id);
    }

}

