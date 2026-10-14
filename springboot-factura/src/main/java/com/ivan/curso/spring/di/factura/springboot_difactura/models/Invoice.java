package com.ivan.curso.spring.di.factura.springboot_difactura.models;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component 
@RequestScope 
@JsonIgnoreProperties ({"targetSource","advisors"})
public class Invoice {
    
    @Autowired 
    private Client client;

    @Value ("${invoice.description}")
    private String description;

    @Autowired
    @Qualifier("office")
    private List<Item> items;

    @PostConstruct 
    public void init() {
        client.setName(client.getName().toUpperCase());
        description = description.concat(" of client: ").concat(client.getName()).concat(" ").concat(client.getLastName());
    }

    @PreDestroy 
    public void destroy() {
        System.out.println("Invoice destroyed: ".concat(description));
    }

    public Client getClient() {
        return client;
    }
    public void setClient(Client client) {
        this.client = client;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public List<Item> getItems() {
        return items;
    }
    public void setItems(List<Item> items) {
        this.items = items;
    }

    public Double getTotal() {
        // forma 1 de calcular el total de la factura
        // Double total = 0.0;
        // for (Item item : items) {
        //     total += item.getTotal();
        // }

        // forma 2 de calcular el total de la factura
        Double total = items.stream().mapToDouble(item -> item.getTotal()).sum();
        return total;
    }
}
