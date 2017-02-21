package com.maggioni.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "BasicServlet", 
        urlPatterns = "/BasicServletDemo",
        initParams = {
            @WebInitParam(name = "FirstName", value = "Angelo"),
            @WebInitParam(name = "LastName", value = "Maggioni")
        }
)
public class BasicServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log("-->> doGet called");
        log("-->> initParameter FirstName : " + getInitParameter("FirstName"));
        log("-->> initParameter LastName : " + getInitParameter("LastName"));
    }
    
    
}
