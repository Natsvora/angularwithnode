package com.example.demo.controller;

import com.example.demo.model.School;
import com.example.demo.model.Student;
import com.example.demo.service.SchoolService;
import com.example.demo.service.StudentService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class Controller {

    @Autowired
    private StudentService studentService;
    @Autowired
    private SchoolService schoolService;

    @RequestMapping("/")
    public String sayHi() {
        return "index";
    }

    @RequestMapping("/school")
    public String schoolForm() {
        return "school";
    }

    @RequestMapping(value = "/saveschool", method = RequestMethod.GET)
    public School saveSchool(@ModelAttribute School user) {

        user.getStudentList().add(studentService.getStudent(1));
        user.getStudentList().add(studentService.getStudent(2));
        user.getStudentList().add(studentService.getStudent(3));
        user.getStudentList().add(studentService.getStudent(4));
        schoolService.addSchool(user);
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("student-data");
//        modelAndView.addObject("student", user);
//        return modelAndView;
        return schoolService.getSchool(3);
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ModelAndView save(@ModelAttribute Student user) {
        studentService.addStudent(user);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("student-data");
        modelAndView.addObject("student", user);
        return modelAndView;
    }

    @RequestMapping("/getstudent")
    public List<Student> getAllUser() {
        return studentService.getAllStudents();
    }

    @RequestMapping(value = "/addstudent", method = RequestMethod.POST)
    public void addUser(@RequestBody Student student) {
        studentService.addStudent(student);
    }

    @RequestMapping(value = "/student/{id}", method = RequestMethod.GET)
    public Student getUser(@PathVariable int id) {
        return studentService.getStudent(id);
    }
}
