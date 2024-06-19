package com.catalogApp.catalog.controller;

import com.catalogApp.catalog.entity.Student;
import com.catalogApp.catalog.service.ProgramStudiuService;
import com.catalogApp.catalog.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.UUID;

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
        // Setează anul studentului (de exemplu, pentru anul 1)
        student.setAn(1);

        // Generare grupă conform cerințelor
        String grupa = generateGrupa(student);
        student.setGrupa(grupa);

        // Salvare student
        studentService.saveStudent(student);

        return "redirect:/studenti";
    }
    private String generateGrupa(Student student) {
        // Extract relevant information for group generation
        boolean isLicenta = student.getProgramStudiu().isLicenta();
        int anAdmitere = student.getAn() % 10;

        // Determine the last digit based on medieDeIntrare (average entrance grade)
        int lastDigit=0;
        float medie = student.getMedieDeIntrare();

        if (medie >= 9.5) {
            lastDigit = 1;
        } else if (medie >= 9) {
            lastDigit = 2;
        } else if (medie >= 8.5) {
            lastDigit = 3;
        } else if (medie >= 8) {
            lastDigit = 4;
        }


        // Build the group code according to the requirements
        String grupa = student.getProgramStudiu().getDurata() + "F" + student.getProgramStudiu().getId() + anAdmitere + lastDigit;

        return grupa;
    }
    @GetMapping("/studenti")
    public String studenti(Model model) {
        List<Student> studenti =studentService.getStudenti();
        model.addAttribute("studenti",studenti);
        return "studenti";
    }

    @GetMapping("/deleteStudent/{id}")
    public String deleteStudent(@PathVariable UUID id) {
        studentService.deleteStudent(id);
        return("redirect:/studenti");
    }

    @GetMapping("/updateStudent/{id}")
    public String updateStudent(@PathVariable UUID id, Model model) {
        model.addAttribute("student",studentService.getStudentById(id));
        return "student-form";
    }



}
