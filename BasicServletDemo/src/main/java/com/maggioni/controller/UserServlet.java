package com.maggioni.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        parseHTMLPage(response);
    }

    private void parseHTMLPage(HttpServletResponse response) throws IOException {
        response.setContentType("text/html,charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<HTML>");
        out.println("<BODY>");
        out.println("<H1>User Servlet</H1>");
        out.println("Hallo Angelo");
        out.println("</BODY>");
        out.println("</HTML>");
    }

}
