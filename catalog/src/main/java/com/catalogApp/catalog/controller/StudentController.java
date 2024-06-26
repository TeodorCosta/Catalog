package com.catalogApp.catalog.controller;

import com.catalogApp.catalog.entity.Nota;
import com.catalogApp.catalog.entity.Student;
import com.catalogApp.catalog.service.ProgramStudiuService;
import com.catalogApp.catalog.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

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
        String tip;
       if(student.getProgramStudiu().isLicenta()==true){
           tip="L";
       }
          else tip="M";

        int anAdmitere = student.getAn() % 10;
        String programStudiuDurata = String.valueOf(student.getProgramStudiu().getDurata());
        String programStudiuId = String.valueOf(student.getProgramStudiu().getId());
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

        StringBuilder grupaBuilder = new StringBuilder();
        grupaBuilder.append(programStudiuDurata)
                .append(tip)
                .append("F")
                .append(programStudiuId)
                .append(anAdmitere)
                .append(lastDigit);

        String grupa = grupaBuilder.toString();

        return grupa;
    }
    @GetMapping("/studenti")
    public String studenti(Model model) {
        List<Student> studenti =studentService.getStudenti();
        model.addAttribute("studenti",studenti);
        Set<String> uniqueGrupe = studenti.stream()
                .map(Student::getGrupa)
                .collect(Collectors.toSet());
        model.addAttribute("uniqueGrupe", uniqueGrupe);
        return "studenti";
    }

    @GetMapping("/studenti-search-nume")
    public String studentiSearchNume(Model model, @RequestParam("searchItem") String searchItem) {
        List<Student>searchResults = studentService.findStudentsByName(searchItem);
        model.addAttribute("results", searchResults);
        model.addAttribute("query", searchItem);
        List<Student>studentiToti =studentService.getStudenti();
        Set<String> uniqueGrupe = studentiToti.stream()
                .map(Student::getGrupa)
                .collect(Collectors.toSet());
        model.addAttribute("uniqueGrupe", uniqueGrupe);
        return "studenti-results";
    }
    @GetMapping("/studenti-search-grupa")
    public String searchByGrupa(Model model, @RequestParam String post) {
        List<Student> studenti = studentService.findStudentsByGrupa(post);
        model.addAttribute("studenti", studenti);
        List<Student>studentiToti =studentService.getStudenti();
        Set<String> uniqueGrupe = studentiToti.stream()
                .map(Student::getGrupa)
                .collect(Collectors.toSet());
        model.addAttribute("uniqueGrupe", uniqueGrupe);
        return "studenti";
    }
    @GetMapping("/program/{id}/an{an}")
    public String studentiAn(Model model, @PathVariable UUID id, @PathVariable Integer an) {
        List<Student> studenti = studentService.getStudentiByProgramStudiuAndAn(id, an);
        model.addAttribute("studenti", studenti);
        return "studenti";
    }
    @GetMapping("/catalog/{id}")
    public String catalog(Model model, @PathVariable UUID id) {
        Student student = studentService.getStudentById(id);

        // Group by year
        Map<Integer, Map<Integer, List<Nota>>> groupedByYearAndSemester = student.getDiscipline().stream()
                .collect(Collectors.groupingBy(nota -> nota.getDisciplina().getAn(),
                        Collectors.groupingBy(nota -> nota.getDisciplina().getSemestru())));

        model.addAttribute("student", student);
        model.addAttribute("groupedByYearAndSemester", groupedByYearAndSemester);

        return "catalog";
    }
    @GetMapping("/catalog/{id}/an{an}")
    public String catalog(Model model, @PathVariable UUID id, @PathVariable Integer an) {
        List<Student> studenti = studentService.getStudentiByProgramStudiuAndAn(id, an);
        model.addAttribute("studenti", studenti);
        return "catalog-mare";
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
    @GetMapping("/program/{id}/an{an}")
    public String studentiAn(Model model, @PathVariable Integer id, @PathVariable Integer an) {
        List<Student> studenti = studentService.getStudentiByProgramStudiuAndAn(id, an);
        model.addAttribute("studenti", studenti);
        Set<String> uniqueGrupe = studenti.stream()
                .map(Student::getGrupa)
                .collect(Collectors.toSet());
        model.addAttribute("uniqueGrupe", uniqueGrupe);
        return "studenti";
    }
    @GetMapping("/catalog/{id}")
    public String catalog(Model model, @PathVariable UUID id) {
        Student student = studentService.getStudentById(id);

        // Group by year
        Map<Integer, Map<Integer, List<Nota>>> groupedByYearAndSemester = student.getDiscipline().stream()
                .collect(Collectors.groupingBy(nota -> nota.getDisciplina().getAn(),
                        Collectors.groupingBy(nota -> nota.getDisciplina().getSemestru())));

        model.addAttribute("student", student);
        model.addAttribute("groupedByYearAndSemester", groupedByYearAndSemester);

        return "catalog";
    }
    @GetMapping("/catalog/{id}/an{an}")
    public String catalogMare(Model model, @PathVariable Integer id, @PathVariable Integer an) {
        List<Student> studenti = studentService.getStudentiByProgramStudiuAndAn(id, an);
        model.addAttribute("studenti", studenti);
        return "catalog-mare";
    }





}
