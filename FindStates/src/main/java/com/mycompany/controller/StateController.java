/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controller;

import com.mycompany.findstates.MapState;
import com.mycompany.findstates.StateName;
import java.util.HashMap;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class StateController {

    @RequestMapping("/")
    public ModelAndView showForm() {
        ModelAndView model = new ModelAndView("stateform");
        model.addObject("state", new StateName());

        return model;
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ModelAndView save(@ModelAttribute("state") StateName state) {
        ModelAndView model;
        String name = state.getState();
        if (name.equals("")) {
            model = new ModelAndView("missingdata");

        } else {

            ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");

            MapState map = (MapState) context.getBean("map");
            String Abr = map.findAbr(name);
            if (Abr == null) {
                model = new ModelAndView("unknownstate");
                model.addObject("name",name);
               
                return model;
            }
            model = new ModelAndView("stateabr");
            model.addObject("name", name);
            model.addObject("abr", Abr);

        }

        return model;
    }

}
