package com.catalogApp.catalog.controller;

import com.catalogApp.catalog.entity.Disciplina;
import com.catalogApp.catalog.service.CadruDidacticService;
import com.catalogApp.catalog.service.DisciplinaService;
import com.catalogApp.catalog.service.ProgramStudiuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class DisciplinaController {

    @Autowired
    DisciplinaService disciplinaService;

    @Autowired
    CadruDidacticService cadruDidacticService;

    @Autowired
    ProgramStudiuService programStudiuService;

    @GetMapping("/disciplina_form")
    public String disciplinaForm(Model model) {
        model.addAttribute("cadreDidactice",cadruDidacticService.getcadreDidactice());
        model.addAttribute("disciplina", new Disciplina());
        model.addAttribute("programeStudiu", programStudiuService.getProgrameStudiu());
        return "disciplina-form";
    }
    @PostMapping("/save_disciplina")
    public String saveDisciplina(Disciplina disciplina) {
        disciplinaService.saveDisciplina(disciplina);

        return ("redirect:/discipline");
    }
    @GetMapping("/discipline")
    public String discipline(Model model) {
        List<Disciplina> discipline =disciplinaService.getDiscipline();
        model.addAttribute("discipline",discipline);
        return "discipline";
    }

}

