package com.cyp.dao.impl;

import com.cyp.dao.DEPTDao;
import com.cyp.domain.DEPT;
import com.cyp.domain.Product;
import com.cyp.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DEPTDaoImpl implements DEPTDao {
    @Override
    public void addDEPT(DEPT dept) throws SQLException {
        JDBCUtils jdbcUtils=new JDBCUtils();
        Connection connection=jdbcUtils.getConnection();
        String sql="insert into dept(dname,loc) values(?,?)";
        PreparedStatement preparedStatement=connection.prepareStatement(sql);
        jdbcUtils.addDeleteUpdate(preparedStatement,dept.getDname(),dept.getLoc());
        jdbcUtils.release(preparedStatement,connection);
    }

    @Override
    public void removeDEPT(int id) throws SQLException {
        JDBCUtils jdbcUtils=new JDBCUtils();
        Connection connection=jdbcUtils.getConnection();
        String sql="delete from dept where deptno=?";
        PreparedStatement preparedStatement=connection.prepareStatement(sql);
        jdbcUtils.addDeleteUpdate(preparedStatement,id);
        jdbcUtils.release(preparedStatement,connection);
    }

    @Override
    public void updateDEPT(DEPT dept) throws SQLException {
        JDBCUtils jdbcUtils=new JDBCUtils();
        Connection connection=jdbcUtils.getConnection();
        String sql="update dept set dname=?,loc=? where deptno=?";
        PreparedStatement preparedStatement=connection.prepareStatement(sql);
        jdbcUtils.addDeleteUpdate(preparedStatement,dept.getDname(),dept.getLoc(),dept.getDeptno());
        jdbcUtils.release(preparedStatement,connection);
    }

    @Override
    public DEPT findDEPTById(int id) throws SQLException {
        JDBCUtils jdbcUtils=new JDBCUtils();
        Connection connection=jdbcUtils.getConnection();
        String sql="select * from dept where deptno=?";
        PreparedStatement preparedStatement=connection.prepareStatement(sql);
        ResultSet resultSet=jdbcUtils.select(preparedStatement,id);
        DEPT dept=null;
        if (resultSet.next()){
            dept=new DEPT(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3));
        }
        jdbcUtils.release(resultSet,preparedStatement,connection);
        return dept;
    }

    @Override
    public List<DEPT> findAllDEPT() throws SQLException {
        JDBCUtils jdbcUtils=new JDBCUtils();
        Connection connection=jdbcUtils.getConnection();
        String sql="select * from dept";
        PreparedStatement preparedStatement=connection.prepareStatement(sql);
        ResultSet resultSet=jdbcUtils.select(preparedStatement);
        List<DEPT> depts=new ArrayList<>();
        while (resultSet.next()){
            depts.add(new DEPT(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3)));
        }
        jdbcUtils.release(resultSet,preparedStatement,connection);
        return depts;
    }
}
