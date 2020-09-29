package com.cyp.service.impl;

import com.cyp.dao.EmpDao;
import com.cyp.dao.impl.EmpDaoImpl;
import com.cyp.domain.Emp;
import com.cyp.service.EmpService;
import com.cyp.utils.Page;

import java.sql.SQLException;
import java.util.List;

public class EmpServiceImpl implements EmpService {
    EmpDao empDao=new EmpDaoImpl();
    @Override
    public void addEmp(Emp emp) {
        try {
            empDao.addEmp(emp);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void removeEmp(int id) {
        try {
            empDao.removeEmp(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateEmp(Emp emp) {
        try {
            empDao.updateEmp(emp);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Emp findEmpById(int id) {
        Emp emp= null;
        try {
            emp = empDao.findEmpById(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return emp;
    }

    @Override
    public List<Emp> findAllEmp() {
        List<Emp> emps= null;
        try {
            emps = empDao.findAllEmp();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return emps;
    }

    @Override
    public Page<Emp> selectByPage(int currentPage, int pageSize) {
        Page<Emp> page= null;
        try {
            page = empDao.selectByPage(currentPage,pageSize);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return page;
    }
}
