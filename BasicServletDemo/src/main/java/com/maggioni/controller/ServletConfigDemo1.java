package com.maggioni.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ServletConfig1", urlPatterns = "/Config1")
public class ServletConfigDemo1 extends HttpServlet{

    private ServletConfig sc;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<h1>ServletConfig Demo</h1>");
        out.println("<br> Servelt Config :" + sc);
        out.println("<br> getServletName() :" + sc.getServletName());
        out.println("<br> getServletContext() :" + sc.getServletContext());
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        sc = config;
    }
    
    
    
}
