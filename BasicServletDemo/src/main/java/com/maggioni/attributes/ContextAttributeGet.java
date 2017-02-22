package com.maggioni.attributes;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/AttributeGet")
public class ContextAttributeGet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ServletContext servletContext = getServletContext();
        synchronized (servletContext) {
            String country = (String) servletContext.getAttribute("Country");
            int plz = (int) servletContext.getAttribute("PLZ");
            parseResponsePage(response, country, plz);
        }
    }

    private void parseResponsePage(HttpServletResponse response, String country, int plz) throws IOException {
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<h1>Get Context Attribute Demo</h1>");
        out.println("<br> Country : " + country);
        out.println("<br> PLZ : " + plz);
    }

}
