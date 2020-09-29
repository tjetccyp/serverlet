package com.cyp.controller.emp;

import com.cyp.domain.DEPT;
import com.cyp.domain.Emp;
import com.cyp.service.EmpService;
import com.cyp.service.impl.EmpServiceImpl;
import com.cyp.utils.Page;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class EmpController extends HttpServlet {
    private EmpService empService;

    public EmpController() {
        this.empService = new EmpServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
         String encoding=this.getServletContext().getInitParameter("encoding");
         req.setCharacterEncoding(encoding);
         resp.setCharacterEncoding(encoding);
         String op=req.getParameter("op");
         if ("listEmp".equals(op)){
             this.listEmp(req,resp);
         }else if("removeEmp".equals(op)){
             this.removeEmp(req,resp);
         }else if("updateEmp".equals(op)){
                 this.updateEmp(req,resp);

         }else if("addEmp".equals(op)){
             this.addEmp(req,resp);
         }else if("findEmp".equals(op)){
             this.findEmp(req,resp);
         }else if("textEL".equals(op)){
             this.textEL(req,resp);
         }else if("selectByPage".equals(op)){
             this.selectByPage(req,resp);
         }
    }

    private void selectByPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String currentPage =req.getParameter("currentPage");
        EmpService empService=new EmpServiceImpl();
        Page<Emp> page= empService.selectByPage(currentPage!=null?Integer.parseInt(currentPage):1,3);
        req.setAttribute("page",page);
        req.getRequestDispatcher("emp/selectByPage.jsp").forward(req,resp);

    }

    private void textEL(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id=req.getParameter("id");
        Emp emp=this.empService.findEmpById(Integer.parseInt(id));
        req.setAttribute("emp",emp);
        req.getRequestDispatcher("emp/textEL.jsp").forward(req,resp);
    }

    private void updateEmp(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String id=req.getParameter("id");
        String name=req.getParameter("name");
        String job=req.getParameter("job");
        String mgr=req.getParameter("mgr");
        String hiredate=req.getParameter("hiredate");
        String sal=req.getParameter("sal");
        String comm=req.getParameter("comm");
        String deptno=req.getParameter("deptno");
        SimpleDateFormat s=new SimpleDateFormat("yyyy-MM-dd");
        Date date= null;
        try {
            date = s.parse(hiredate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        this.empService.updateEmp(new Emp(Integer.parseInt(id),name,job,Integer.parseInt(mgr),date,Double.parseDouble(sal),Double.parseDouble(comm),new DEPT(Integer.parseInt(deptno))));
        listEmp(req,resp);
    }

    private void findEmp(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id=req.getParameter("id");
        Emp emp=this.empService.findEmpById(Integer.parseInt(id));
        req.setAttribute("emp",emp);
        req.getRequestDispatcher("emp/findEmp.jsp").forward(req,resp);
    }



    private void addEmp(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name=req.getParameter("name");
        String job=req.getParameter("job");
        String mgr=req.getParameter("mgr");
        String hiredate=req.getParameter("hiredate");
        String sal=req.getParameter("sal");
        String comm=req.getParameter("comm");
        String deptno=req.getParameter("deptno");
        SimpleDateFormat s=new SimpleDateFormat("yyyy-MM-dd");
        Date date= null;
        try {
            date = s.parse(hiredate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        resp.getWriter().println(date);
        this.empService.addEmp(new Emp(name,job,Integer.parseInt(mgr),date,Double.parseDouble(sal),Double.parseDouble(comm),new DEPT(Integer.parseInt(deptno))));
        listEmp(req,resp);
    }

    private void removeEmp(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id=req.getParameter("id");
        this.empService.removeEmp(Integer.parseInt(id));
        listEmp(req,resp);
    }

    private void listEmp(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Emp> emps=this.empService.findAllEmp();
        req.setAttribute("emps",emps);
        req.getRequestDispatcher("emp/listEmp.jsp").forward(req,resp);
    }
}
