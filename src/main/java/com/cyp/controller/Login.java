package com.cyp.controller;

import com.cyp.dao.UserDao;
import com.cyp.dao.impl.UserDaoImpl;
import com.cyp.domain.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

public class Login extends HttpServlet {
    @Override
    public void init() throws ServletException {
        System.out.println("初始化");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        PrintWriter out=resp.getWriter();
        String name=req.getParameter("name");
        String pwd=req.getParameter("pwd");
        String msg=req.getParameter("msg");
        resp.setContentType("text/html;charset=UTF-8");
        UserDao userDao=new UserDaoImpl();
        User user= null;
        try {
            user = userDao.findUserByNameAndPwd(name,pwd);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (user==null){
            req.setAttribute("msg","对不起，登录失败，请重新登录！");
            req.getRequestDispatcher("login.jsp").forward(req,resp);
        }else {
            HttpSession session=req.getSession();
            session.setAttribute("user",user);
            int count=(int)this.getServletContext().getAttribute("count");
            this.getServletContext().setAttribute("count",count+1);
            resp.sendRedirect("front.jsp");
        }
    }

    @Override
    public void destroy() {
        System.out.println("死亡");
    }

}
