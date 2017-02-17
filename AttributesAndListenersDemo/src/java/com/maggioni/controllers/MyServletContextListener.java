package com.maggioni.controllers;

import com.maggioni.model.Dog;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MyServletContextListener implements ServletContextListener {

    static final Logger LOGGER = Logger.getLogger("root.ContextListener");
    
    @Override
    public void contextInitialized(ServletContextEvent event) {
        LOGGER.info("->>>> contextInitialized called");
        ServletContext sc = event.getServletContext();
        String dogBreed = sc.getInitParameter("breed");
        
        Dog dog = new Dog(dogBreed);
        
        sc.setAttribute("dog", dog);
    }
    
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        // nothing to do here at the moment
    }
    
}
