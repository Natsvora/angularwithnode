/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.argusoft.springtest;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 *
 * @author naimish
 */
@Component
public class CustomEventHandler implements ApplicationListener<CustomEvent> {
   public void onApplicationEvent(CustomEvent event) {
      System.out.println(event.toString());
   }
}
