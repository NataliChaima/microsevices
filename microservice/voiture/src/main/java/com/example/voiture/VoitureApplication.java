package com.example.voiture;

import com.example.voiture.entity.Client;
import com.example.voiture.entity.Voiture;
import com.example.voiture.repository.VoitureRepo;
import jakarta.transaction.Transactional;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@SpringBootApplication
public class VoitureApplication {
    private final ClientService clientService;
    private final VoitureRepo voitureRepository;


    public VoitureApplication(VoitureRepo voitureRepository, ClientService clientService) {
        this.voitureRepository = voitureRepository;
        this.clientService = clientService;
    }

    public static void main(String[] args) {
        SpringApplication.run(VoitureApplication.class, args);
    }

    @FeignClient(name = "SERVICE-CLIENT")
    interface ClientService {
        @GetMapping(path = "/clients/{id}")
        Client clientById(@PathVariable Long id);
    }

    @Transactional
    @Bean
    CommandLineRunner initializeDatabase(VoitureRepo voitureRepository, ClientService clientService) {
        return args -> {

        };
    }
}
