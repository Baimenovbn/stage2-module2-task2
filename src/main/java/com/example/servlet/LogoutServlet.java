package com.example.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)  {
        HttpSession session = req.getSession();
        session.removeAttribute("user");
        session.invalidate();
        try {
            req.getRequestDispatcher("/login.jsp").forward(req, resp);
        } catch (IOException | ServletException e) {
            e.getLocalizedMessage();
        }
    }
}
