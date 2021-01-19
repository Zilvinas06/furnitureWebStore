package com.zilvinasTamosaitis.furnitureWebStore.Config;

import com.zilvinasTamosaitis.furnitureWebStore.model.Product;
import com.zilvinasTamosaitis.furnitureWebStore.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class ProductConfig {
    @Bean
    CommandLineRunner commandLineRunner(ProductRepository repository) {
        return args -> {
            Product chair = new Product(
                    "kede",
                    "chair",
                    2,
                    "lithuania",
                    45.99F,
                    "black suede"
            );

            Product table = new Product(
                    "kede",
                    "chair",
                    3,
                    "lithuania",
                    120.99F,
                    "black wood"
            );

            repository.saveAll(
                    List.of(chair, table)
            );
        };
    }
}
