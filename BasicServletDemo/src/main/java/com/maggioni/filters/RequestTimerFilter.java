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

@WebFilter(urlPatterns = "/*")
public class RequestTimerFilter implements Filter{

    private static final Logger logger = Logger.getLogger("root.Filter");
    private FilterConfig filterConfig;
    
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
        logger.info("-->>  RequestTimerFilter initialized");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        long before = System.currentTimeMillis();
        chain.doFilter(request, response);
        long after = System.currentTimeMillis();
        
        String requestURI = ((HttpServletRequest)request).getRequestURI();
        logger.info("--->> "+requestURI + ": " + (after-before) + " msec");
    }

    @Override
    public void destroy() {
        logger.info("--->>  RequestTimerFilter destroyed");
    }
    
}
