/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.argusoft.springtest;

import java.util.Locale;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEvent;
import org.springframework.stereotype.Component;
import sun.applet.AppletEvent;
import sun.applet.AppletListener;

/**
 *
 * @author naimish
 */

import org.springframework.context.ApplicationEvent;

public class CustomEvent extends ApplicationEvent{
    private int lan;
    private ApplicationContext context;
    public CustomEvent(Object source,ApplicationContext context,int lan) {
      super(source);
      this.lan = lan;
      this.context = context;
   }
   public String toString(){
      return context.getMessage(lan+".event", null, "Not Found", null);
   }
}
