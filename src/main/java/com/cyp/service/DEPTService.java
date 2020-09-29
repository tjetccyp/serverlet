package com.cyp.service;

import com.cyp.domain.DEPT;
import com.cyp.domain.Product;

import java.util.List;

public interface DEPTService {
    void addDEPT(DEPT dept);
    void removeDEPT(int id);
    void updateDEPT(DEPT dept);
    DEPT findDEPTById (int id);
    List<DEPT> findAllDEPT();
}
