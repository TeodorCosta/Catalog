package com.catalogApp.catalog.service;

import com.catalogApp.catalog.entity.Student;
import com.catalogApp.catalog.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public void saveStudent(Student student){

        studentRepository.save(student);
    }

}
