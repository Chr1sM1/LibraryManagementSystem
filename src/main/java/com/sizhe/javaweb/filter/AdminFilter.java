package com.sizhe.javaweb.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @ClassName AdminFilter
 * @Description AdminFilter
 * @Author Chris
 * @Date 2021/5/26
 **/

@WebFilter(filterName = "AdminFilter", urlPatterns = "/login")
public class AdminFilter implements Filter {
    @Override
    public void doFilter(ServletRequest req,
                         ServletResponse resp,
                         FilterChain chain)
            throws IOException, ServletException {
        String role = req.getParameter("role");

        if ("0".equals(role)) {
            req.getRequestDispatcher(
                    "/admin/login").forward(req, resp);
        } else {
            req.getRequestDispatcher("/login").forward(req, resp);
        }
    }
}
