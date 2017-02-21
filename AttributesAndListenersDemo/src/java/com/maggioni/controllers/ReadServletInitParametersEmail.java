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
        
        log("->> processRequest startet" );
        parseHeader(response);
        
        InitParameter initParameter = new InitParameter();
        Enumeration<String> initParameterNames = getServletConfig().getInitParameterNames();
        while (initParameterNames.hasMoreElements()) {
            final String initParameterName = initParameterNames.nextElement();
            initParameter.setInitParameterName(initParameterName);
            initParameter.setInitParameterValue(getServletConfig().getInitParameter(initParameterName));
            
            parseNextElement(initParameter, response);
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

    private void parseNextElement(InitParameter initParameter, HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();
        out.println("<br> parameter name : " + initParameter.getInitParameterName() + " Value : " + initParameter.getInitParameterValue());
    }

}

class InitParameter {

    private String initParameterName;
    private String initParameterValue;

    public String getInitParameterName() {
        return initParameterName;
    }

    public void setInitParameterName(String initParameterName) {
        this.initParameterName = initParameterName;
    }

    public String getInitParameterValue() {
        return initParameterValue;
    }

    public void setInitParameterValue(String initParameterValue) {
        this.initParameterValue = initParameterValue;
    }

}
