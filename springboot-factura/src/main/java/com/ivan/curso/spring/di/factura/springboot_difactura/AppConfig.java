package com.ivan.curso.spring.di.factura.springboot_difactura;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.ivan.curso.spring.di.factura.springboot_difactura.models.Item;
import com.ivan.curso.spring.di.factura.springboot_difactura.models.Product;

@Configuration 
@PropertySource("classpath:data.properties")
public class AppConfig {

    @Bean("default")
    List<Item> itemsInvoice(){
        Product product1 = new Product("Camera Sony", 100.00);
        Product product2 = new Product("Bicycle", 200.00);
        
        return Arrays.asList(new Item(product1, 2), new Item(product2, 4));
    }

    @Bean("office")
    List<Item> itemsInvoiceOffice(){
        Product product1 = new Product("Office Chair", 100.00);
        Product product2 = new Product("Office Desk", 200.00);
        Product product3 = new Product("Office Lamp", 200.00);
        Product product4 = new Product("Office Computer", 200.00);
        
        return Arrays.asList(new Item(product1, 2), new Item(product2, 4), new Item(product3, 3), new Item(product4, 1));
    }
}
