package com.catalogApp.catalog.controller;

import com.catalogApp.catalog.entity.Student;
import com.catalogApp.catalog.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping("/student_form")
    public String studentForm(Model model) {
        model.addAttribute("student", new Student());
        return "student-form";
    }
    @PostMapping("/save_student")
    public String saveStudent(Student student) {
       studentService.saveStudent(student);

        return ("redirect:/studenti");
    }
    @GetMapping("/studenti")
    public String studenti(Model model) {
        List<Student> studenti =studentService.getStudenti();
        model.addAttribute("studenti",studenti);
        return "studenti";
    }
}
