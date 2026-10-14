package com.aleks.springboot.di.app.springboot_di.repositories;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.aleks.springboot.di.app.springboot_di.models.Product;

import tools.jackson.databind.ObjectMapper;

public class ProductRepositoryJson implements ProductRepository {
    
    private List<Product> products;
    
    public ProductRepositoryJson() {
        Resource resource = new ClassPathResource("json/products.json");
        readValueJson(resource);
    }

    public ProductRepositoryJson(Resource resource) {
        readValueJson(resource);
    }

    private void readValueJson(Resource resource){
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            products = Arrays.asList(objectMapper.readValue(resource.getFile(), Product[].class));  
        } catch (IOException e) {
            e.printStackTrace();
            products = List.of(); 
        }
    }
    
    @Override
    public List<Product> findAll() {
        // Implementación para leer productos desde un archivo JSON
        return products; // Retorna la lista de productos
    }

    @Override
    public Product findById(Long id) {
        return products.stream().filter(p -> p.getId().equals(id)).findFirst().orElse(null);
    }

}
