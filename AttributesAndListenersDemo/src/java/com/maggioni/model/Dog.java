
package com.maggioni.model;

import java.util.logging.Logger;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

public class Dog implements HttpSessionBindingListener{
    
    private static final Logger logger = Logger.getLogger("root.HttpSessionAttributeListener");
    private String breed;

    public Dog(String breed) {
        this.breed = breed;
    }

    public String getBreed() {
        return breed;
    } 

    @Override
    public void valueBound(HttpSessionBindingEvent event) {
        logger.info("-->> attribute :" + event.getName() + " value :" + event.getValue() + " bound");
        logger.info("-->> attribute :" + event.getSession().getAttribute("dog") + " bound");
    }

    @Override
    public void valueUnbound(HttpSessionBindingEvent event) {
        logger.info("-->> attribute :" + event.getName() + " value :" + event.getValue() + " UNbound");
        logger.info("-->> attribute :" + event.getSession().getAttribute("dog") + " UNbound");
    }

}
