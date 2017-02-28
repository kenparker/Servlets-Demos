package com.maggioni.filters;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

@WebFilter(urlPatterns = "/UserServlet")
public class CheckRequestFilter implements Filter {

    private FilterConfig filterConfig;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        String user = ((HttpServletRequest) request).getParameter("User");

        if (user.equals("Angelo")) {
            chain.doFilter(request, response);
        } else {
            ServletContext servletContext = filterConfig.getServletContext();
            servletContext.log("--->> User " + user + " not authorized");
            parseHTMLPage(response);
        }
    }

    @Override
    public void destroy() {
    }

    private void parseHTMLPage(ServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<HTML>");
        out.println("<BODY>");
        out.println("<H1>User Not Allowed</H1>");
        out.println("Sorry, User Not Allowed.");
        out.println("</BODY>");
        out.println("</HTML>");
    }

}
