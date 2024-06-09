package com.catalogApp.catalog.controller;

import com.catalogApp.catalog.dto.NotaDto;
import com.catalogApp.catalog.entity.Disciplina;
import com.catalogApp.catalog.entity.Nota;
import com.catalogApp.catalog.entity.Student;
import com.catalogApp.catalog.service.DisciplinaService;
import com.catalogApp.catalog.service.NotaService;
import com.catalogApp.catalog.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.UUID;

@Controller
public class NotaController {

    @Autowired
    NotaService notaService;

    @Autowired
    StudentService studentService;

    @Autowired
    DisciplinaService disciplinaService;

    @GetMapping("/notare")
    public String notare(Model model, @ModelAttribute("nota2")NotaDto nota){
        List<Student> studenti = studentService.getStudenti();
        List<Disciplina> discipline =disciplinaService.getDiscipline();
        model.addAttribute("discipline", discipline);
        model.addAttribute("studenti", studenti);
        model.addAttribute("utils",disciplinaService);
        return ("notare");
    }
    @PostMapping("/save_nota")
    public String saveNota(NotaDto nota, RedirectAttributes redirectAttributes){
        Nota notaToBeAdded = Nota.builder()
                .disciplina(disciplinaService.getDisciplinaById(UUID.fromString(nota.getDisciplina_id())))
                        .student(studentService.getStudentById(UUID.fromString(nota.getStudent_id())))
                .valoare(nota.getValoare())
                .build();
        notaService.saveNota(notaToBeAdded);
        return ("redirect:/notare");
    }
}
