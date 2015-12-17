package com.java.supinfo.supbartering.dao;

import com.java.supinfo.supbartering.dao.entity.Product;
import java.util.List;

/**
 * Created by Alex on 11/12/2015.
 */

public interface ProductDao {

    public List<Product> getCheaperProducts();
    Product addProduct(Product product);
    public void updateProduct(Product product);
    List<Product> getAllProducts();
    public Product findProductById(Long idProduct);
    public void removeProduct(Product findProductById);
}
