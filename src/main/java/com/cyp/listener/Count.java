package com.cyp.listener;

import com.cyp.utils.JDBCUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Count implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        JDBCUtils jdbcUtils=new JDBCUtils();
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        try {
            connection=jdbcUtils.getConnection();
            String sql="select count from count";
            preparedStatement=connection.prepareStatement(sql);
            resultSet=jdbcUtils.select(preparedStatement);
            int count=0;
            if (resultSet.next()){
                count=resultSet.getInt(1);
            }
            ServletContext servletContext=servletContextEvent.getServletContext();
            servletContext.setAttribute("count",count);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            jdbcUtils.release(resultSet,preparedStatement,connection);
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        JDBCUtils jdbcUtils=new JDBCUtils();
        Connection connection= null;
                PreparedStatement preparedStatement=null;
        try {
            connection=jdbcUtils.getConnection();
            String sql="update count set count=?";
            preparedStatement=connection.prepareStatement(sql);

            jdbcUtils.addDeleteUpdate(preparedStatement,(int)servletContextEvent.getServletContext().getAttribute("count"));

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            jdbcUtils.release(preparedStatement,connection);
        }
    }
}
