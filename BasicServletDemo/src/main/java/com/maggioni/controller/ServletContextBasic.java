package com.maggioni.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ContextBasic", urlPatterns = "/ContextBasic")
public class ServletContextBasic extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext servletContext = getServletContext();
        ServletContext servletContextFromConfig = getServletConfig().getServletContext();
        
        parseResponsePage(response, servletContext, servletContextFromConfig);
        
    }

    private void parseResponsePage(HttpServletResponse response, ServletContext servletContext, ServletContext servletContextFromConfig) throws IOException {
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<h1>Context Basic</h1>");
        out.println("<br>servletContext                     : " +  servletContext);
        out.println("<br>servletContext from ServletConfig  : " +  servletContextFromConfig);
    }
    
    
}
