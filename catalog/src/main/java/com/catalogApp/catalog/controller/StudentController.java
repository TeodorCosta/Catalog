package com.catalogApp.catalog.controller;

import com.catalogApp.catalog.entity.Student;
import com.catalogApp.catalog.service.ProgramStudiuService;
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

    @Autowired
    ProgramStudiuService programStudiuService;

    @GetMapping("/student_form")
    public String studentForm(Model model) {
        model.addAttribute("student", new Student());
        model.addAttribute("programeStudiu", programStudiuService.getProgrameStudiu());
        return "student-form";
    }
    @PostMapping("/save_student")
    public String saveStudent(Student student) {
        student.setAn(1);
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
