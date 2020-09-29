package com.cyp.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class JDBCUtils {
    private static String driver;
    private static String url;
    private static String username;
    private static String password;
    static {
        Properties properties=new Properties();
        try {
            InputStream in = JDBCUtils.class.getResourceAsStream("/db.properties");
            properties.load(in);
            url=properties.getProperty("url");
            username=properties.getProperty("user");
            password=properties.getProperty("password");
            driver=properties.getProperty("driver");
            Class.forName(driver);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url,username,password);
    }
    private void release(Connection connection){
        if (connection!=null){
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    private void release(PreparedStatement preparedStatement){
        if (preparedStatement!=null){
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    private void release(ResultSet resultSet){
        if (resultSet!=null){
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public void release(ResultSet resultSet, PreparedStatement preparedStatement, Connection connection){
        release(resultSet);
        release(preparedStatement);
        release(connection);
    }
    public void release(PreparedStatement preparedStatement,Connection connection){
        release(preparedStatement);
        release(connection);
    }
    public void addDeleteUpdate(PreparedStatement preparedStatement,Object ...obj){
        try {
            for (int i = 0; i < obj.length; i++) {
                preparedStatement.setObject((i+1),obj[i]);
            }
                preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public  ResultSet select(PreparedStatement preparedStatement,Object... object){
        ResultSet resultSet=null;
        try {
            for (int i = 0; i < object.length; i++) {
                preparedStatement.setObject((i+1),object[i]);
            }
            resultSet=preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }
    //分页总条数
    public int getTotalData(){
        int i= 0;
        try {
            Connection connection=getConnection();
            String sql="select count(1) from emp";
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            ResultSet resultSet=select(preparedStatement);
            i = 0;
            if (resultSet.next()){
                i=resultSet.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return i;
    }

}
