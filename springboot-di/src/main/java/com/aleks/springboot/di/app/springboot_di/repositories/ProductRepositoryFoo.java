package com.aleks.springboot.di.app.springboot_di.repositories;

import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.aleks.springboot.di.app.springboot_di.models.Product;

// se agrega nombre especifico al bean para poder inyectarlo en el servicio y no tener conflicto con el otro bean que es el primario.
@Repository("productList") 
public class ProductRepositoryFoo implements ProductRepository {

    @Override
    public List<Product> findAll() {
        return Collections.singletonList(new Product(1L, "Monitor CRUA", 5000L));
    }

    @Override
    public Product findById(Long id) {
        return new Product(id, "Monitor CRUA", 5000L);
    }

}
