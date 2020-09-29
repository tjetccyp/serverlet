package com.cyp.service;

import com.cyp.domain.Product;

import java.sql.SQLException;
import java.util.List;

public interface ProductService {
    void addProduct(Product product);
    void removePeoduct(int id);
    void updateProduct(Product product);
    Product findProductById (int id);
    List<Product> findAllProduct();
}
