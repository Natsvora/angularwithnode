/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.service;

import com.example.demo.model.School;
import com.example.demo.model.Student;
import com.example.demo.repository.SchoolRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author naimish
 */
@Service
public class SchoolService {

    @Autowired
    private SchoolRepository schoolRepository;

    public List<School> getAllSchools() {
        List<School> studentRepositorys = new ArrayList<>();
        schoolRepository.findAll().forEach(studentRepositorys::add);
        return studentRepositorys;
    }

    public School getSchool(int id) {
        return schoolRepository.findOne(id);
    }

    public void addSchool(School school) {
        schoolRepository.save(school);
    }

    public void delete(int id) {
        schoolRepository.delete(id);
    }
}
