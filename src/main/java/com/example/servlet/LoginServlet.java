package com.example.servlet;

import com.example.Users;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String user = (String) req.getSession().getAttribute("user");

        if (user == null) {
            req.getRequestDispatcher("user/hello.jsp").forward(req, resp);
        } else {
            req.getRequestDispatcher("/login.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getAttribute("login");
        RequestDispatcher dispatcher;

        if (Users.getInstance().getUsers().contains(req.getAttribute("login")) || req.getAttribute("password").equals("")) {
            dispatcher = req.getRequestDispatcher("/user/hello.jsp");
        } else {
            dispatcher = req.getRequestDispatcher("/login.jsp");
        }

        dispatcher.forward(req, resp);
    }
}
