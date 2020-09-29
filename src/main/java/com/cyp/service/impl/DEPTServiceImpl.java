package com.cyp.service.impl;

import com.cyp.dao.DEPTDao;
import com.cyp.dao.impl.DEPTDaoImpl;
import com.cyp.domain.DEPT;
import com.cyp.domain.Product;
import com.cyp.service.DEPTService;

import java.sql.SQLException;
import java.util.List;

public class DEPTServiceImpl implements DEPTService {
    DEPTDao deptDao=new DEPTDaoImpl();
    @Override
    public void addDEPT(DEPT dept) {
        try {
            deptDao.addDEPT(dept);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void removeDEPT(int id) {
        try {
            deptDao.removeDEPT(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateDEPT(DEPT dept) {
        try {
            deptDao.updateDEPT(dept);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public DEPT findDEPTById(int id) {
        DEPT dept= null;
        try {
            dept = deptDao.findDEPTById(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dept;
    }

    @Override
    public List<DEPT> findAllDEPT() {
        List<DEPT> depts= null;
        try {
            depts = deptDao.findAllDEPT();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return depts;
    }
}
