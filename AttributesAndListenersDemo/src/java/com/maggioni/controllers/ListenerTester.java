package com.maggioni.controllers;

import com.maggioni.model.Dog;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ListenerTester extends HttpServlet {

    static final Logger LOGGER = Logger.getLogger("root.ListenerTester");
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        parseHeader(response);
        ServletContext servletContext = request.getServletContext();
        Dog dog = (Dog) servletContext.getAttribute("dog");
        parseDog(dog, response);
    }

    private void parseHeader(HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("test context attrubutes set by listener<br>");
    }

    private void parseDog(Dog dog, HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();
        final String dogString = "-->> Dog's breed is : " + dog.getBreed() + " dog object is : " + dog;
        out.println(dogString);
        
        LOGGER.info(dogString);
        LOGGER.info("-->> PrintWriter : " + out);
    }

}
