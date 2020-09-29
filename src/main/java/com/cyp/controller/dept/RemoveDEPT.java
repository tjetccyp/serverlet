package com.cyp.controller.dept;

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

public class RemoveDEPT extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        PrintWriter out=resp.getWriter();
        String id=req.getParameter("id");
        DEPTService deptService=new DEPTServiceImpl();
        deptService.removeDEPT(Integer.parseInt(id));
        req.getRequestDispatcher("ListDEPT").forward(req,resp);
    }
}
