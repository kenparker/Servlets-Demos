package com.maggioni.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SimpleServlet extends HttpServlet {

    //A variable that is NOT thread-safe!
    private int counter = 0;

    public void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.getWriter().println("<HTML><BODY>");
        resp.getWriter().println(this + ": <br>");
        for (int c = 0; c < 10; c++) {
            resp.getWriter().println("Counter = " + counter + "<BR>");
            try {
                Thread.currentThread().sleep((long) Math.random() * 10000);
                counter++;
            } catch (InterruptedException exc) {}
        }
        resp.getWriter().println("</BODY></HTML>");
    }

}
