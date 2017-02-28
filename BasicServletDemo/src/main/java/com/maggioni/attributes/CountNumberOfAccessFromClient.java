package com.maggioni.attributes;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "CountAccessSession", urlPatterns = "/CountAccess")
public class CountNumberOfAccessFromClient extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        Integer accessCount;
        synchronized (session) {
            accessCount = (Integer) session.getAttribute("accessCount");
            accessCount = incrementAccessCount(accessCount);
            session.setAttribute("accessCount", accessCount);
        }

        parseHTMLPage(session, request, response);
    }

    private Integer incrementAccessCount(Integer accessCount) {
        if (accessCount == null) {
            return 0;
        } else {
            return new Integer(accessCount + 1);
        }
    }

    private void parseHTMLPage(HttpSession session, HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head><meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>");
            out.println("<title>Session Test Servlet</title></head><body>");
            out.println("<h2>You have access this site " + session.getAttribute("accessCount") + " times in this session.</h2>");
            out.println("<p>(Session ID is " + session.getId() + ")</p>");
            out.println("<p>(Session creation time is "
                    + new Date(session.getCreationTime()) + ")</p>");
            out.println("<p>(Session last access time is "
                    + new Date(session.getLastAccessedTime()) + ")</p>");
            out.println("<p>(Session max inactive interval  is "
                    + session.getMaxInactiveInterval() + " seconds)</p>");
            out.println("<p><a  href='" + request.getRequestURI() + "'>Refresh</a>");
            out.println("<p><a  href='" + response.encodeURL(request.getRequestURI())
                    + "'>Refresh with  URL rewriting</a>");
            out.println("</body></html>");
        } finally {
            out.close();
        } 
    }

}
