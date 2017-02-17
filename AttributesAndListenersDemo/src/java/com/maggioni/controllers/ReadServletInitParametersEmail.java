package com.maggioni.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ReadServletInitParametersEmail extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        parseHeader(response);
        Enumeration<String> initParameterNames = getServletConfig().getInitParameterNames();
        while (initParameterNames.hasMoreElements()) {
            String nextElement = initParameterNames.nextElement();
            parseNextElement(nextElement, response);
        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    private void parseHeader(HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("Test Init Parameters<br>");
    }

    private void parseNextElement(String nextElement, HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();
        String initParameter = getServletConfig().getInitParameter(nextElement);
        out.println("<br> parameter name : " + nextElement + " " + initParameter);
    }

}
