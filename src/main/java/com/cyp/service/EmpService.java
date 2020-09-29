package com.cyp.service;

import com.cyp.domain.Emp;
import com.cyp.utils.Page;

import java.sql.SQLException;
import java.util.List;

public interface EmpService {
    void addEmp(Emp emp);
    void removeEmp(int id);
    void updateEmp(Emp emp);
    Emp findEmpById (int id);
    List<Emp> findAllEmp();
    Page<Emp> selectByPage(int currentPage, int pageSize);
}
