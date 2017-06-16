package com.project.servlets;

import com.project.dao.UserDao;
import com.project.entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("index.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = UserDao.INSTANCE.getUserByLoginAndPassword(req.getParameter("login"), req.getParameter("password"));
        if (user == null) {
            req.getRequestDispatcher("registration.jsp");
        }
    }
}
