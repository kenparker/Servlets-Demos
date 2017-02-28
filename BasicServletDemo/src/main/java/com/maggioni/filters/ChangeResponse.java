package com.maggioni.filters;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Logger;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

@WebFilter(
        urlPatterns = "/*",
        initParams = {
            @WebInitParam(name = "message1", value = "I'm from"),
            @WebInitParam(name = "message2", value = " Filter")}
)
public class ChangeResponse implements Filter {

    private static final Logger logger = Logger.getLogger("root.ChangeResponse");
    private FilterConfig filterConfig;
    
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        chain.doFilter(request, response);
        
        PrintWriter out = response.getWriter();
        String message1 = filterConfig.getInitParameter("message1");
        String message2 = filterConfig.getInitParameter("message2");
        out.println("<br>-->> Filter Init Parameters : " +  message1 + message2 );
    }

    @Override
    public void destroy() {
        
    }

}
