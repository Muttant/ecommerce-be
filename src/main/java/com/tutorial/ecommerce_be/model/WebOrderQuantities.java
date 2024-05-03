package com.tutorial.ecommerce_be.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "web_order_quantities")
public class WebOrderQuantities {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @Column(name = "quantity", nullable = false)
    private String quantity;
    @JsonIgnore
    @ManyToOne(optional = false)
    @JoinColumn(name = "order_id", nullable = false)
    private WebOrder order;

    public WebOrder getOrder() {
        return order;
    }

    public void setOrder(WebOrder order) {
        this.order = order;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}