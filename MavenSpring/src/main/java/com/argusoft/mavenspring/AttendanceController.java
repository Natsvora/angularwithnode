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
import java.text.ParseException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author naimish
 */
@Controller
public class AttendanceController {

    @Autowired  
    EmpDao EmpDao;//will inject dao from xml file 
    @Autowired
    DeptDao DeptDao;
    @Autowired
    AttDao AttDao;
    
    
    @RequestMapping("/")
    public ModelAndView index() {
        return new ModelAndView("index");
    }

    @RequestMapping("/addattendance")
    public ModelAndView addAttendence() {
        //command is a reserved request attribute name, now use <form> tag to show object data  
        List<Emp> l1 = EmpDao.getAll();
        List<Dept> l2 = DeptDao.getAll();
        ModelAndView mav = new ModelAndView("addatt");
        mav.addObject("emplist", l1);
        mav.addObject("deptlist", l2);
        return mav;
    }

    @RequestMapping("/modifyattendance")
    public ModelAndView viewAttendence() {
        //command is a reserved request attribute name, now use <form> tag to show object data  
        List l1 = AttDao.getAll();

        ModelAndView mav = new ModelAndView("viewatt");
        mav.addObject("list", l1);
        return mav;
    }

    @RequestMapping(value = "/addattendence/{id}/{date}")
    public ModelAndView delete(@PathVariable("id") int id, @PathVariable("date") String date) {
        try {
            AttDao.insertAtt(id, date);
        } catch (ParseException ex) {
            Logger.getLogger(AttendanceController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new ModelAndView("redirect:/addattendance");
    }

    @RequestMapping(value = "/deleteatt/{id}")
    public ModelAndView deleteAtt(@PathVariable("id") int id) {
        //command is a reserved request attribute name, now use <form> tag to show object data  
        AttDao.delete(id);
        return new ModelAndView("redirect:/modifyattendance");
    }

    @RequestMapping("/mntrpt")
    public ModelAndView generateReport() {
        List list = AttDao.getReport();
        return new ModelAndView("report", "list", list);
    }

    @RequestMapping("/serrpt")
    public ModelAndView serch(HttpServletRequest request, HttpServletResponse res) {
        if (request.getParameter("ename") != null) {
            List list = AttDao.serchReport(request.getParameter("ename"));
            return new ModelAndView("serchemp", "list",list);
        } else {
            return new ModelAndView("serchemp");
        }
    }

}
