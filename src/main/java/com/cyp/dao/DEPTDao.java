package com.cyp.dao;

import com.cyp.domain.DEPT;

import java.sql.SQLException;
import java.util.List;

public interface DEPTDao {
    void addDEPT(DEPT dept) throws SQLException;
    void removeDEPT(int id) throws SQLException;
    void updateDEPT(DEPT dept) throws SQLException;
    DEPT findDEPTById (int id) throws SQLException;
    List<DEPT> findAllDEPT() throws SQLException;
}
