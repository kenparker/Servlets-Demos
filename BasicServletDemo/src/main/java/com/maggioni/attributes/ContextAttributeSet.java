package com.maggioni.attributes;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/AttributeSet")
public class ContextAttributeSet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ServletContext servletContext = getServletContext();
        synchronized (servletContext) {
            servletContext.setAttribute("Country", "Germany");
            servletContext.setAttribute("PLZ", 80333);
            parseResponsePage(response);
        }
    }

    private void parseResponsePage(HttpServletResponse response) throws IOException {
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<h1>Set Context Attribute Demo</h1>");
    }

}
