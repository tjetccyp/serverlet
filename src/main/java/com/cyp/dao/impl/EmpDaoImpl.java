package com.cyp.dao.impl;

import com.cyp.dao.DEPTDao;
import com.cyp.dao.EmpDao;
import com.cyp.domain.DEPT;
import com.cyp.domain.Emp;
import com.cyp.domain.Product;
import com.cyp.utils.JDBCUtils;
import com.cyp.utils.Page;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmpDaoImpl implements EmpDao {
    @Override
    public void addEmp(Emp emp) throws SQLException {
        JDBCUtils jdbcUtils=new JDBCUtils();
        Connection connection=jdbcUtils.getConnection();
        String sql="insert into emp(ename,job,mgr,hiredate,sal,comm,deptno) values(?,?,?,?,?,?,?)";
        PreparedStatement preparedStatement=connection.prepareStatement(sql);
        jdbcUtils.addDeleteUpdate(preparedStatement,emp.getEname(),emp.getJob(),emp.getMgr(),emp.getHiredate(),emp.getSal(),emp.getComm(),emp.getDept().getDeptno());
        jdbcUtils.release(preparedStatement,connection);
    }

    @Override
    public void removeEmp(int id) throws SQLException {
        JDBCUtils jdbcUtils=new JDBCUtils();
        Connection connection=jdbcUtils.getConnection();
        String sql="delete from emp where empno=?";
        PreparedStatement preparedStatement=connection.prepareStatement(sql);
        jdbcUtils.addDeleteUpdate(preparedStatement,id);
        jdbcUtils.release(preparedStatement,connection);
    }

    @Override
    public void updateEmp(Emp emp) throws SQLException {
        JDBCUtils jdbcUtils=new JDBCUtils();
        Connection connection=jdbcUtils.getConnection();
        String sql="update emp set ename=?,job=?,mgr=?,hiredate=?,sal=?,comm=?,deptno=? where empno=?";
        PreparedStatement preparedStatement=connection.prepareStatement(sql);
        jdbcUtils.addDeleteUpdate(preparedStatement,emp.getEname(),emp.getJob(),emp.getMgr(),emp.getHiredate(),emp.getSal(),emp.getComm(),emp.getDept().getDeptno(),emp.getEmpno());
        jdbcUtils.release(preparedStatement,connection);
    }

    @Override
    public Emp findEmpById(int id) throws SQLException {
        DEPTDao deptDao=new DEPTDaoImpl();
        JDBCUtils jdbcUtils=new JDBCUtils();
        Connection connection=jdbcUtils.getConnection();
        String sql="select * from emp where empno=?";
        PreparedStatement preparedStatement=connection.prepareStatement(sql);
        ResultSet resultSet=jdbcUtils.select(preparedStatement,id);
        Emp emp=null;
        if (resultSet.next()){
            emp=new Emp(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3),resultSet.getInt(4),resultSet.getDate(5),resultSet.getDouble(6),resultSet.getDouble(7),deptDao.findDEPTById(resultSet.getInt(8)));
        }
        jdbcUtils.release(resultSet,preparedStatement,connection);
        return emp;
    }

    @Override
    public List<Emp> findAllEmp() throws SQLException {
        DEPTDao deptDao=new DEPTDaoImpl();
        JDBCUtils jdbcUtils=new JDBCUtils();
        Connection connection=jdbcUtils.getConnection();
        String sql="select * from emp";
        PreparedStatement preparedStatement=connection.prepareStatement(sql);
        ResultSet resultSet=jdbcUtils.select(preparedStatement);
        List<Emp> emps=new ArrayList<>();
        while (resultSet.next()){
            emps.add(new Emp(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3),resultSet.getInt(4),resultSet.getDate(5),resultSet.getDouble(6),resultSet.getDouble(7),deptDao.findDEPTById(resultSet.getInt(8))));
        }
        jdbcUtils.release(resultSet,preparedStatement,connection);
        return emps;
    }

    @Override
    public Page<Emp> selectByPage(int currentPage, int pageSize) throws SQLException {
        DEPTDao deptDao=new DEPTDaoImpl();
        JDBCUtils jdbcUtils=new JDBCUtils();
        int totalPage=jdbcUtils.getTotalData();
        Page<Emp> page=new Page<>(currentPage,pageSize);
        page.setTotalData(totalPage);
        Connection connection=jdbcUtils.getConnection();
        String sql="select * from emp limit ?,?";
        PreparedStatement preparedStatement=connection.prepareStatement(sql);
        ResultSet resultSet=jdbcUtils.select(preparedStatement,page.startIndex(),pageSize);
        List<Emp> emps=new ArrayList<>();
        while (resultSet.next()){
            emps.add(new Emp(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3),resultSet.getInt(4),resultSet.getDate(5),resultSet.getDouble(6),resultSet.getDouble(7),deptDao.findDEPTById(resultSet.getInt(8))));
        }
        page.setData(emps);
        return page;
    }
}
