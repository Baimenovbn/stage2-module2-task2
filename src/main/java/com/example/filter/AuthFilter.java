package com.example.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(
        urlPatterns = {"/users/*"},
        dispatcherTypes = {DispatcherType.REQUEST}
)
public class AuthFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) {}

    public void doFilter(HttpServletRequest req, HttpServletResponse res) {
        try {
            if ((req.getSession().getAttribute("user")) == null) {
                req.getRequestDispatcher("/login.jsp").forward(req, res);
            }
        } catch (IOException | ServletException e) {
            e.getLocalizedMessage();
        }
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws ServletException {
        if (req instanceof HttpServletRequest && res instanceof HttpServletResponse) {
            this.doFilter((HttpServletRequest)req, (HttpServletResponse)res, chain);
        } else {
            throw new ServletException("non-HTTP request or response");
        }
    }
}