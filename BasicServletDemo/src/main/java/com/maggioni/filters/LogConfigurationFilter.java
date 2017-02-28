package com.maggioni.filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

@WebFilter(urlPatterns = "/*")
public class LogConfigurationFilter implements Filter{

    private FilterConfig filterConfig;
    
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        long start = System.currentTimeMillis();
        
        chain.doFilter(request, response);
        
        long end = System.currentTimeMillis();
        
        String localAddr = request.getLocalAddr();
        int localPort = request.getLocalPort();
        String protocol = request.getProtocol();
        String remoteAddr = request.getRemoteAddr();
        String serverName = request.getServerName();
        String requestURI = ((HttpServletRequest) request).getRequestURI();
        
        ServletContext servletContext = filterConfig.getServletContext();
        servletContext.log("--->> LogConfigFilter --------------------------");
        servletContext.log("--->> LogConfigFilter : localAddr : " + localAddr);
        servletContext.log("--->> LogConfigFilter : localPort : " + localPort);
        servletContext.log("--->> LogConfigFilter : protocol : " + protocol);
        servletContext.log("--->> LogConfigFilter : remoteAddr : " + remoteAddr);
        servletContext.log("--->> LogConfigFilter : serverName : " + serverName);
        servletContext.log("--->> LogConfigFilter : requestURI : " + requestURI);
        servletContext.log("--->> LogConfigFilter : Milliseconds used : " + (end-start));
    }

    @Override
    public void destroy() {
        System.out.println("");
    }
    
}
