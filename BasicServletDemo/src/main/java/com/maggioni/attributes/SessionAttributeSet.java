package com.maggioni.attributes;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns = "/SessionSet")
public class SessionAttributeSet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        synchronized (session) {
            session.setAttribute("Adresse", "Reigersbachstr. 36");

            parseResponsePage(response, session);
        }
    }

    private void parseResponsePage(HttpServletResponse response, HttpSession session) throws IOException {
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<h1>Set Session Attribute Demo</h1>");
        out.println("<br> Session Id : " + session.getId());

    }
}
