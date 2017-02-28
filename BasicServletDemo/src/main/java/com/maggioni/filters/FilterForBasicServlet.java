package com.maggioni.filters;

import java.io.IOException;
import java.util.logging.Logger;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

@WebFilter(servletNames = "BasicServlet")
public class FilterForBasicServlet implements Filter {

    private static final Logger logger = Logger.getLogger("root.FilterForBasicServlet");

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        logger.info("-->>  FilterForBasicServlet initialized");

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        long start = System.currentTimeMillis();
        chain.doFilter(request, response);
        long end = System.currentTimeMillis();
        String requestURI = ((HttpServletRequest)request).getRequestURI();
        logger.info("--->> "+requestURI + ": " + (end-start) + " msec");
    }

    @Override
    public void destroy() {
        logger.info("-->>  FilterForBasicServlet initialized");

    }

}
