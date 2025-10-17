package org.example.inventory;

import org.example.inventory.entities.product;
import org.example.inventory.repository.ProductRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.UUID;

@SpringBootApplication
public class InventoryApplication {

    public static void main(String[] args) {
        SpringApplication.run(InventoryApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(ProductRepo productRepo) {
        return args -> {
            productRepo.save(product.builder()
                    .id(UUID.randomUUID().toString())
                    .name("Computer")
                    .price(3200)
                    .quantity(2)
                    .build());
            productRepo.save(product.builder()
                    .id(UUID.randomUUID().toString())
                    .name("printer")
                    .price(30000)
                    .quantity(10)
                    .build());
            productRepo.save(product.builder()
                    .id(UUID.randomUUID().toString())
                    .name("phone")
                    .price(100)
                    .quantity(6)
                    .build());

            productRepo.findAll().forEach(P->{
                System.out.println(P.toString());
            });
        };
    }
}
