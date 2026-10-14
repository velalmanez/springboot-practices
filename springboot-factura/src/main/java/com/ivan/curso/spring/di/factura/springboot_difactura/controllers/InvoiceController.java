package com.ivan.curso.spring.di.factura.springboot_difactura.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ivan.curso.spring.di.factura.springboot_difactura.models.Client;
import com.ivan.curso.spring.di.factura.springboot_difactura.models.Invoice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController 
@RequestMapping ("/invoices")
public class InvoiceController {
    
    @Autowired 
    private Invoice invoice;

    @GetMapping("/show")
    public Invoice showInvoice() {
        Invoice i = new Invoice();
        Client c = new Client();
        
        c.setLastName(invoice.getClient().getLastName());
        c.setName(invoice.getClient().getName());

        i.setClient(c);
        i.setDescription(invoice.getDescription());
        i.setItems(invoice.getItems());
        
        return i;
    }
}
