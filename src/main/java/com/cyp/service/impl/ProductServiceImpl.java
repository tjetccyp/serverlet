package com.cyp.service.impl;

import com.cyp.dao.ProductDao;
import com.cyp.dao.impl.ProductDaoImpl;
import com.cyp.domain.Product;
import com.cyp.service.ProductService;

import java.sql.SQLException;
import java.util.List;

public class ProductServiceImpl implements ProductService {
    ProductDao productDao=new ProductDaoImpl();
    @Override
    public void addProduct(Product product){
        try {
            productDao.addProduct(product);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void removePeoduct(int id) {
        try {
            productDao.removePeoduct(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateProduct(Product product){
        try {
            productDao.updateProduct(product);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Product findProductById(int id){
        Product product= null;
        try {
            product = productDao.findProductById(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product;
    }

    @Override
    public List<Product> findAllProduct(){
        List<Product> products= null;
        try {
            products = productDao.findAllProduct();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }
}
