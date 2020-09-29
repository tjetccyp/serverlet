package com.cyp.dao;

import com.cyp.domain.User;

import java.sql.SQLException;

public interface UserDao {
    User findUserByNameAndPwd(String name,String password) throws SQLException;
}
