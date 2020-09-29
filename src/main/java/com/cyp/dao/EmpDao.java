package com.cyp.dao;

import com.cyp.domain.Emp;
import com.cyp.domain.Product;
import com.cyp.utils.Page;

import java.sql.SQLException;
import java.util.List;

public interface EmpDao {
    void addEmp(Emp emp) throws SQLException;
    void removeEmp(int id) throws SQLException;
    void updateEmp(Emp emp) throws SQLException;
    Emp findEmpById (int id) throws SQLException;
    List<Emp> findAllEmp() throws SQLException;
    Page<Emp> selectByPage(int currentPage, int pageSize) throws SQLException;
}
