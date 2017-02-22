
package com.maggioni.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "InitParametersDemo1", 
        urlPatterns = "/InitPar1",
        initParams = {
            @WebInitParam(name = "FirstName", value = "Angelo"),
            @WebInitParam(name = "LastName", value = "Maggioni")
        }
)
public class ServletInitParametersDemo1 extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String FirstName = getInitParameter("FirstName"); // from GenericServlet
        ServletConfig sc = getServletConfig();
        String LastName = sc.getInitParameter("LastName");  // from ServletConfig
        
        parseResponsePage(response, FirstName, LastName);
    }

    private void parseResponsePage(HttpServletResponse response, String FirstName, String LastName) throws IOException {
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<h1>Init Parameters Demo 1</h1>");
        out.println("<br>First Name : " + FirstName + " Last Name : " + LastName);
    }
    
    
}
