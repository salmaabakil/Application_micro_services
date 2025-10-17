package org.example.tp3_architecture_microservices;

import org.example.tp3_architecture_microservices.entities.Customer;
import org.example.tp3_architecture_microservices.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Tp3ArchitectureMicroServicesApplication {

    public static void main(String[] args) {
        SpringApplication.run(Tp3ArchitectureMicroServicesApplication.class, args);
    }

    @Bean
    CommandLineRunner init(CustomerRepository customerRepository) {
        return args -> {
            customerRepository.save(Customer.builder()
                    .name("Mohamed").email("med@gmail.com")
                    .build());
            customerRepository.save(Customer.builder()
                    .name("Salma").email("salma@gmail.com")
                    .build());
            customerRepository.save(Customer.builder()
                    .name("leila").email("lee@gmail.com")
                    .build());

            customerRepository.findAll().forEach(c->{
                System.out.println("=================================");
                System.out.println(c.getId());
                System.out.println(c.getName());
                System.out.println(c.getEmail());
                System.out.println("=================================");
            });
        };
    }

}
