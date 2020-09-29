package com.cyp.controller.product;

import com.cyp.domain.Product;
import com.cyp.service.ProductService;
import com.cyp.service.impl.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class ShowBackstage extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        PrintWriter out=resp.getWriter();
        ProductService productService=new ProductServiceImpl();
        List<Product> products= productService.findAllProduct();
        req.setAttribute("products",products);
        req.getRequestDispatcher("/product/showBackstage.jsp").forward(req,resp);
    }
}
