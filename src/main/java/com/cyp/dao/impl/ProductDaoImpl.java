package com.cyp.dao.impl;

import com.cyp.dao.ProductDao;
import com.cyp.domain.Product;
import com.cyp.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDaoImpl implements ProductDao {
    @Override
    public void addProduct(Product product) throws SQLException {
        JDBCUtils jdbcUtils=new JDBCUtils();
        Connection connection=jdbcUtils.getConnection();
        String sql="insert into product(pro_name,pro_price,pro_img1,pro_img2,pro_title,pro_info) values(?,?,?,?,?,?)";
        PreparedStatement preparedStatement=connection.prepareStatement(sql);
        jdbcUtils.addDeleteUpdate(preparedStatement,product.getPro_name(),product.getPro_price(),product.getPro_img1(),product.getPro_img2(),product.getPro_title(),product.getPro_info());
        jdbcUtils.release(preparedStatement,connection);
    }

    @Override
    public void removePeoduct(int id) throws SQLException {
        JDBCUtils jdbcUtils=new JDBCUtils();
        Connection connection=jdbcUtils.getConnection();
        String sql="delete from product where pro_id=?";
        PreparedStatement preparedStatement=connection.prepareStatement(sql);
        jdbcUtils.addDeleteUpdate(preparedStatement,id);
        jdbcUtils.release(preparedStatement,connection);
    }

    @Override
    public void updateProduct(Product product) throws SQLException {
        JDBCUtils jdbcUtils=new JDBCUtils();
        Connection connection=jdbcUtils.getConnection();
        String sql="update product set pro_name=?,pro_price=?,pro_img1=?,pro_img2=?,pro_title=?,pro_info=? where pro_id=?";
        PreparedStatement preparedStatement=connection.prepareStatement(sql);
        jdbcUtils.addDeleteUpdate(preparedStatement,product.getPro_name(),product.getPro_price(),product.getPro_img1(),product.getPro_img2(),product.getPro_title(),product.getPro_info(),product.getPro_id());
        jdbcUtils.release(preparedStatement,connection);
    }

    @Override
    public Product findProductById(int id) throws SQLException {
        JDBCUtils jdbcUtils=new JDBCUtils();
        Connection connection=jdbcUtils.getConnection();
        String sql="select * from product where pro_id=?";
        PreparedStatement preparedStatement=connection.prepareStatement(sql);
        ResultSet resultSet=jdbcUtils.select(preparedStatement,id);
        Product  product=null;
        if (resultSet.next()){
            product=new Product(resultSet.getInt(1),resultSet.getString(2),resultSet.getInt(3),resultSet.getString(4),resultSet.getString(5),resultSet.getString(6),resultSet.getString(7));
        }
        jdbcUtils.release(resultSet,preparedStatement,connection);
        return product;
    }

    @Override
    public List<Product> findAllProduct() throws SQLException {
        JDBCUtils jdbcUtils=new JDBCUtils();
        Connection connection=jdbcUtils.getConnection();
        String sql="select * from product";
        PreparedStatement preparedStatement=connection.prepareStatement(sql);
        ResultSet resultSet=jdbcUtils.select(preparedStatement);
        List<Product> products=new ArrayList<>();
        while (resultSet.next()){
            products.add(new Product(resultSet.getInt(1),resultSet.getString(2),resultSet.getInt(3),resultSet.getString(4),resultSet.getString(5),resultSet.getString(6),resultSet.getString(7)));
        }
        jdbcUtils.release(resultSet,preparedStatement,connection);
        return products;
    }
}
