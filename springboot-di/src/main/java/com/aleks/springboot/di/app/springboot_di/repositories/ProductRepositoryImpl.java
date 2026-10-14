package com.aleks.springboot.di.app.springboot_di.repositories;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import org.springframework.web.context.annotation.RequestScope;

import com.aleks.springboot.di.app.springboot_di.models.Product;

@Primary
// se modifica el alcance del bean a nivel de request, es decir, cada vez que se haga una peticion http se creara un nuevo bean de este tipo.
@RequestScope  
@Repository  
public class ProductRepositoryImpl implements ProductRepository {
    private List<Product> data;

    public ProductRepositoryImpl(){
        this.data = Arrays.asList(
            new Product(1L, "Corsair 32", 300L),
            new Product(2L, "CPU Intel Core i9", 850L),
            new Product(3L, "Teclado Razer Mini 60%", 180L),
            new Product(4L, "Mother Board Gigabite", 490L)
        );
    }

    @Override 
    public List<Product> findAll(){
        return this.data;
    }

    @Override 
    public Product findById(Long id){
        return this.data.stream().filter(p -> p.getId().equals(id)).findFirst().orElse(null);
    }
}
