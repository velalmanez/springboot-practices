package com.ivan.curso.spring.di.factura.springboot_difactura.models;

public class Item {
    private Product product;
    private Integer quantity;
    private Double total;

    public Item() {
    }

    public Item(Product product, Integer quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }
    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getQuantity() {
        return quantity;
    }
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getTotal() {
        if (this.total == null) {
            this.total = product.getPrice() * quantity.doubleValue();
        }
        return this.total;
    }
}
