/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.argusoft.myhibernate.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author naimish
 */
@Controller
public class StudentController {
    
    @RequestMapping("/")
    public ModelAndView home()
    {
        return new ModelAndView("home");
    }
}
