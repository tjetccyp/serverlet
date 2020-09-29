package com.cyp.dao;

import com.cyp.domain.Product;

import java.sql.SQLException;
import java.util.List;

public interface ProductDao {
    void addProduct(Product product) throws SQLException;
    void removePeoduct(int id) throws SQLException;
    void updateProduct(Product product) throws SQLException;
    Product findProductById (int id) throws SQLException;
    List<Product> findAllProduct() throws SQLException;
}
