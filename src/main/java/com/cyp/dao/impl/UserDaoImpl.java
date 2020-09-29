package com.cyp.dao.impl;

import com.cyp.dao.UserDao;
import com.cyp.domain.User;
import com.cyp.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoImpl implements UserDao {
    @Override
    public User findUserByNameAndPwd(String name, String password) throws SQLException {
        JDBCUtils jdbcUtils=new JDBCUtils();
        Connection connection=jdbcUtils.getConnection();
        String sql="select *from user where user_name=? and user_pwd=?";
        PreparedStatement preparedStatement =connection.prepareStatement(sql);
        ResultSet resultSet=jdbcUtils.select(preparedStatement,name,password);
        if (resultSet.next()){
            return new User(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4));
        }
        jdbcUtils.release(resultSet,preparedStatement,connection);
        return null;
    }
}
