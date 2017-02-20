package com.maggioni.controllers;

import com.maggioni.model.Dog;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ServletSessionAttributeTester extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        
        Dog dog = new Dog("Wolf");
        
        session.setAttribute("dog", dog);
        
    }
        
    
    
}
