package com.cyp.controller;

import com.cyp.domain.Product;
import com.cyp.service.ProductService;
import com.cyp.service.impl.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class Descrption extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        PrintWriter out=resp.getWriter();
        String id=req.getParameter("id");
        ProductService productService=new ProductServiceImpl();
        Product product=productService.findProductById(Integer.parseInt(id));
        req.setAttribute("product",product);
        req.getRequestDispatcher("descrption.jsp").forward(req,resp);
    }
}
