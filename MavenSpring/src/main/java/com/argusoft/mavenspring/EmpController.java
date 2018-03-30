/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.argusoft.mavenspring;

import com.argusoft.mavenspring.bean.Dept;
import com.argusoft.mavenspring.bean.Emp;
import com.argusoft.mavenspring.dao.AttDao;
import com.argusoft.mavenspring.dao.DeptDao;
import com.argusoft.mavenspring.dao.EmpDao;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EmpController {

    @Autowired
    EmpDao EmpDao;//will inject dao from xml file 
    @Autowired
    DeptDao DeptDao;
    @Autowired
    AttDao AttDao;
    

    @RequestMapping("/empform")

    public ModelAndView showform() {
        //command is a reserved request attribute name, now use <form> tag to show object data  
        ModelAndView md = new ModelAndView("empform");
        md.addObject("command", new Emp());
        md.addObject("deptlist", DeptDao.getAll());
        return md;
    }

    @RequestMapping(value = "/Save", method = RequestMethod.POST)
    public ModelAndView save(@ModelAttribute("emp") Emp emp) {
        EmpDao.insert(emp);
        //return new ModelAndView("empform","command",emp);//will display object data  
        return new ModelAndView("redirect:/viewemp");//will redirect to viewemp request mapping  
    }

    @RequestMapping(value = "/empeditform", method = RequestMethod.GET)
    public ModelAndView editform() {
        //command is a reserved request attribute name, now use <form> tag to show object data  
        List<Emp> list = EmpDao.getAll();
        return new ModelAndView("empeditform", "list", list);
    }

    @RequestMapping(value = "/deleteempform")
    public ModelAndView deleteform() {
        //command is a reserved request attribute name, now use <form> tag to show object data  
        List<Emp> list = EmpDao.getAll();
        return new ModelAndView("empdeleteform", "list", list);
    }

    @RequestMapping(value = "/deleteemp/{id}")
    public ModelAndView delete(@PathVariable("id") int id) {
        //command is a reserved request attribute name, now use <form> tag to show object data  
        EmpDao.delete(id);
        return new ModelAndView("redirect:/deleteempform");
    }

    @RequestMapping(value = "/updateempform")
    public ModelAndView update(HttpServletRequest req, HttpServletResponse res) {
        //command is a reserved request attribute name, now use <form> tag to show object data  
        Emp e = new Emp();
        e.setName(req.getParameter("name"));
        e.setSalary(Float.parseFloat(req.getParameter("salary")));
        e.setDesignation(req.getParameter("designation"));
        EmpDao.update(e);
        return new ModelAndView("redirect:/empeditform");
    }

    @RequestMapping("/viewemp")
    public ModelAndView viewemp() {
        //write the code to get all employees from DAO  
        //here, we are writing manual code of list for easy understanding  
        List<Emp> list = EmpDao.getAll();
        return new ModelAndView("viewemp", "list", list);
    }
}
