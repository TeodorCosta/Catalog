package com.catalogApp.catalog.service;

import com.catalogApp.catalog.entity.Student;
import com.catalogApp.catalog.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public void saveStudent(Student student){

        studentRepository.save(student);
    }
    public List<Student> getStudenti(){
        return studentRepository.findAll();
    }
    public Student getStudentById(UUID id){
        return studentRepository.getReferenceById(id);

    }
    public List<Student> getStudentiByProgramStudiuAndAn(UUID programStudiuId, Integer an) {
        return studentRepository.findAll().stream()
                .filter(student -> student.getProgramStudiu().getId().equals(programStudiuId) && student.getAn().equals(an))
                .collect(Collectors.toList());
    }

    public void deleteStudent(UUID id){
        studentRepository.deleteById(id);
    }

}
