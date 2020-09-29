package com.cyp.controller.dept;

import com.cyp.domain.DEPT;
import com.cyp.domain.Product;
import com.cyp.service.DEPTService;
import com.cyp.service.ProductService;
import com.cyp.service.impl.DEPTServiceImpl;
import com.cyp.service.impl.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class AddDEPT extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        PrintWriter out=resp.getWriter();
        DEPTService deptService=new DEPTServiceImpl();
        String name=req.getParameter("name");
        String loc=req.getParameter("loc");
        deptService.addDEPT(new DEPT(name,loc));
        req.getRequestDispatcher("ListDEPT").forward(req,resp);
    }
}
