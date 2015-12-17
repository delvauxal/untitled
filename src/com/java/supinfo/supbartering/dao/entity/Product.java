package com.java.supinfo.supbartering.dao.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Alex on 10/12/2015.
 */

@Entity
@Table(name="products")


public class Product implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idProduct;
    private String productName;
    private String description;
    private float price;

    @ManyToOne User user;

    public Long getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Long idProduct) {
        this.idProduct = idProduct;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductName() {
        return productName;
    }
    public void setDescription(String description){
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public User setUser(User user){
        return this.user = user;
    }

    public User getUser() {
        return user;
    }
}
