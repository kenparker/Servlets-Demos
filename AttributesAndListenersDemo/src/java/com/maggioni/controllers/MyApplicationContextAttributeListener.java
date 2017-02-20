package com.maggioni.controllers;

import java.util.logging.Logger;
import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;

public class MyApplicationContextAttributeListener implements ServletContextAttributeListener{

    private static final Logger logger = Logger.getLogger("root.ContextAttributeListener");
    
    @Override
    public void attributeAdded(ServletContextAttributeEvent event) {
        logger.info("-->> attribute :" + event.getName() + " value :" + event.getValue() + " added");
    }

    @Override
    public void attributeRemoved(ServletContextAttributeEvent event) {
        logger.info("-->> attribute :" + event.getName() + " value :" + event.getValue() + " removed");   
    }

    @Override
    public void attributeReplaced(ServletContextAttributeEvent event) {
        logger.info("-->> attribute :" + event.getName() + " value :" + event.getValue() + " replaced");    
    }
    
}
