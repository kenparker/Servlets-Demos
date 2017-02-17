package com.maggioni.controller;

import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MultiThreadingServlet extends HttpServlet {

    static private final Logger log = Logger.getLogger("root.MultiThreading");
    Integer counter = 0;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        log.info("Platform and Browser : "+ request.getHeader("User-Agent") + " Session : " + request.getSession());
        for (int i = 0; i < 10; i++) {
            delay();
            counter++;
            log.info("[doPost] Counter : " + counter);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    private void delay() {
        ThreadLocalRandom threadLocalRandom = ThreadLocalRandom.current();
        long millis = threadLocalRandom.nextLong(1, 1000 + 1);
        try {
            Thread.sleep(millis);
        } catch (InterruptedException ex) {
        }
    }

}
