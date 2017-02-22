package com.maggioni.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ServletConfig2", urlPatterns = "/Config2")
public class ServletConfigDemo2 extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        ServletConfig sc = getServletConfig();
        
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<h1>ServleConfig Demo</h1>");
        out.println("<br> Servelt Config :" + sc);
        out.println("<br> getServletName() :" + sc.getServletName());
        out.println("<br> getServletContext() :" + sc.getServletContext());
    }
    
    
}
