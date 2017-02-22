package com.maggioni.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/ContextInitParams")
public class ServletContextInitParameters extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext servletContext = getServletContext();
        String FirstName = servletContext.getInitParameter("FirstName");
     
        parseResponsePage(response, FirstName);
    }

    private void parseResponsePage(HttpServletResponse response, String FirstName) throws IOException {
        response.setContentType("texthtml; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<h1>Context Init Parameters</h1>");
        out.print("<br> First Name is : " +  FirstName);
    }
    
    
}
