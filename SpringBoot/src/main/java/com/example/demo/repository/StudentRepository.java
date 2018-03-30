/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.repository;

import com.example.demo.model.Student;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author naimish
 */
public interface StudentRepository extends CrudRepository<Student, Integer> {

    List<Student> findByName(String Name);
}
