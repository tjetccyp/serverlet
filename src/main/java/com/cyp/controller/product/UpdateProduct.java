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

public class UpdateProduct extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        PrintWriter out=resp.getWriter();
        String id=req.getParameter("id");
        String name=req.getParameter("name");
        String price=req.getParameter("price");
        String img1=req.getParameter("img1");
        String img2=req.getParameter("img2");
        String title=req.getParameter("title");
        String info=req.getParameter("info");
        ProductService productService=new ProductServiceImpl();
        productService.updateProduct(new Product(Integer.parseInt(id),name,Integer.parseInt(price),img1,img2,title,info));
        req.getRequestDispatcher("ListProduct").forward(req,resp);
    }
}
