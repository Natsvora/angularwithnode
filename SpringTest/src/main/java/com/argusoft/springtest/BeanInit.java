/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.argusoft.springtest;

/**
 *
 * @author naimish
 */
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.BeansException;
import org.springframework.stereotype.Component;

@Component
public class BeanInit implements BeanPostProcessor {
    
    public Object postProcessBeforeInitialization(Object bean, String beanName)
            throws BeansException {

        // System.out.println("BeforeInitialization : " + beanName);
        return bean;  // you can return any other object as well
    }
    
    public Object postProcessAfterInitialization(Object bean, String beanName)
            throws BeansException {
        
        if (beanName.equals("school")) {
             System.out.println("School is SucessFully Created Now You Can insert Student");
        }
        return bean;  // you can return any other object as well
    }
}
