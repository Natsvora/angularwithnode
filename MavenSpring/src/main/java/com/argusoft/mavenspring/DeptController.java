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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DeptController {

      @Autowired  
    EmpDao EmpDao;//will inject dao from xml file 
    @Autowired
    DeptDao DeptDao;
    @Autowired
    AttDao AttDao;
    
    @RequestMapping("/adddptform")
    public ModelAndView showform() {
        //command is a reserved request attribute name, now use <form> tag to show object data  
        return new ModelAndView("adddeptform", "command", new Dept());
    }

    @RequestMapping(value = "/savedeptform", method = RequestMethod.POST)
    public ModelAndView save(@ModelAttribute("dept") Dept d) {
           DeptDao.insert(d);
        //return new ModelAndView("empform","command",emp);//will display object data  
        return new ModelAndView("redirect:/viewdept");//will redirect to viewemp request mapping  
    }

    @RequestMapping(value = "/editdptform", method = RequestMethod.GET)
    public ModelAndView editform() {
        //command is a reserved request attribute name, now use <form> tag to show object data  
        List<Dept> list = DeptDao.getAll();
        return new ModelAndView("depteditform", "list", list);
    }
    
     @RequestMapping(value = "/deletedptform")
    public ModelAndView deleteform() {
        //command is a reserved request attribute name, now use <form> tag to show object data  
         List<Dept> list = DeptDao.getAll();
        return new ModelAndView("deptdeleteform", "list", list);
    }
    
     @RequestMapping(value ="/deletedept/{id}")
    public ModelAndView delete(@PathVariable("id") int id) {
        //command is a reserved request attribute name, now use <form> tag to show object data  
        DeptDao.delete(id);
        
        return new ModelAndView("redirect:/deletedptform");
    }
    
    @RequestMapping("/updatedptform")
    public ModelAndView updatedept(HttpServletRequest req,HttpServletResponse res) {
        //command is a reserved request attribute name, now use <form> tag to show object data  
        System.out.println("called");
        Dept e= new Dept();
       // e.setId(Integer.parseInt(req.getParameter("did")));
        System.out.println(req.getParameter("did"));
        e.setId(Integer.parseInt(req.getParameter("did")));
        e.setName(req.getParameter("dname"));
        e.setLocation(req.getParameter("loc"));
        System.out.println("redy");
        DeptDao.update(e);
        return new ModelAndView("redirect:/editdptform");
    }
    
    @RequestMapping("/viewdept")
    public ModelAndView viewemp() {
        //write the code to get all employees from DAO  
        //here, we are writing manual code of list for easy understanding  
        List<Dept> list = DeptDao.getAll();
        return new ModelAndView("viewdept", "list", list);
    }
}
