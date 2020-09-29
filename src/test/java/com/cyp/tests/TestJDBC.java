package com.cyp.tests;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.cyp.dao.DEPTDao;
import com.cyp.dao.ProductDao;
import com.cyp.dao.impl.ProductDaoImpl;
import com.cyp.domain.DEPT;
import com.cyp.domain.Emp;
import com.cyp.domain.Product;
import com.cyp.service.DEPTService;
import com.cyp.service.EmpService;
import com.cyp.service.impl.DEPTServiceImpl;
import com.cyp.service.impl.EmpServiceImpl;
import com.cyp.utils.JDBCUtils;
import org.junit.Test;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class TestJDBC {
@Test
    public void test(){
    ProductDao productDao=new ProductDaoImpl();
    DEPTService deptService=new DEPTServiceImpl();
    EmpService empService=new EmpServiceImpl();
    List<Emp> emps=empService.findAllEmp();
    String s=JSON.toJSONString(emps, SerializerFeature.PrettyFormat);

    System.out.println(s);
    //empService.addEmp(new Emp("fdsfdsf","aa",11,new Date(),11,11,new DEPT(10)));
    //empService.removeEmp(7935);
    //empService.updateEmp(new Emp(7936,"aa","aa",11,new Date(),11,11,new DEPT(10)));
    System.out.println(empService.findEmpById(7936));;
    /*for (Emp emp : empService.findAllEmp()) {
        System.out.println(emp);
    }*/
    //deptService.addDEPT(new DEPT("151","515"));
    /*JDBCUtils jdbcUtils=new JDBCUtils();
    try {
        System.out.println(jdbcUtils.getConnection());
    } catch (SQLException e) {
        e.printStackTrace();
    }*/

    /*try {
        ;
        System.out.println(productDao.findProductById(1));
    } catch (SQLException e) {
        e.printStackTrace();
    }*/
    /*try {
        List<Product> products=productDao.findAllProduct();
        for (Product product : products) {
            System.out.println(product);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }*/
    /*try {
        productDao.addProduct(new Product("a",10,"a","a","a","a"));
    } catch (SQLException e) {
        e.printStackTrace();
    }*/
    /*try {
        productDao.removePeoduct(8);
    } catch (SQLException e) {
        e.printStackTrace();
    }*/
    /*try {
        productDao.updateProduct(new Product(9,"b",10,"b","a","a","a"));
    } catch (SQLException e) {
        e.printStackTrace();
    }*/

}
}
