/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.service;

import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author naimish
 */
@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getAllStudents() {
        List<Student> studentRepositorys = new ArrayList<>();
        studentRepository.findAll().forEach(studentRepositorys::add);
        return studentRepositorys;
    }

    public Student getStudent(int id) {
        return studentRepository.findOne(id);
    }

    public void addStudent(Student student) {
        studentRepository.save(student);
    }

    public void delete(int id) {
        studentRepository.delete(id);
    }
}
