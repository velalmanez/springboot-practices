package com.aleks.springboot.di.app.springboot_di.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.aleks.springboot.di.app.springboot_di.models.Product;
import com.aleks.springboot.di.app.springboot_di.repositories.ProductRepository;

@Primary 
@Service 
public class ProductServiceImpl implements ProductService{
        
    private ProductRepository _repository;
    private Environment _env;

    // se especifica que repositorio se va a inyectar (usando el nombre logico),
    // en este caso ProductRepositoryFoo, ya que hay dos implementaciones de ProductRepository
    public ProductServiceImpl(@Qualifier("productJson") ProductRepository repository, Environment env) {
        this._repository = repository;
        this._env = env;
    }

    @Override 
    public List<Product> findAll() {
        return _repository.findAll().stream().map(p ->{
            // Aplicando principio de inmutabilidad
            Double priceTax = p.getPrice() * _env.getProperty("config.price.tax", Double.class);
            Product newProduct = (Product)p.clone();
            newProduct.setPrice(priceTax.longValue());
            return newProduct; 
            
            // p.setPrice(priceTax.longValue());
            // return p;
        }).collect(Collectors.toList());
    }

    @Override 
    public Product findById(Long id) {
        return _repository.findById(id);
    }
}
