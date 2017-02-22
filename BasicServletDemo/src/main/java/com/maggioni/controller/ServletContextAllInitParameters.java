package com.maggioni.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/ContextAllInitParms")
public class ServletContextAllInitParameters extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext servletContext = getServletContext();
        Enumeration<String> initParameterNames = servletContext.getInitParameterNames();

        parseResponsePage(response, initParameterNames, servletContext);

    }

    private void parseResponsePage(HttpServletResponse response, Enumeration<String> initParameterNames, ServletContext servletContext) throws IOException {
        response.setContentType("text/html; chrset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<h1>Context All Init Parameters</h1>");
        while (initParameterNames.hasMoreElements()) {
            String initParameterName = initParameterNames.nextElement();
            String initParameterValue = servletContext.getInitParameter(initParameterName);
            
            out.println("<br> parameter name : " + initParameterName + " / value :" + initParameterValue);
        }
    }
}
