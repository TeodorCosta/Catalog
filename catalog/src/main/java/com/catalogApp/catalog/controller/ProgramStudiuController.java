package com.catalogApp.catalog.controller;

import com.catalogApp.catalog.entity.ProgramStudiu;
import com.catalogApp.catalog.service.ProgramStudiuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ProgramStudiuController {

    @Autowired
    ProgramStudiuService programStudiuService;


    @GetMapping("/programStudiu_form")
    public String programStudiiForm(Model model){
        model.addAttribute("programStudiu",new ProgramStudiu());
        return("programStudii-form");
    }
    @PostMapping("/save_programStudiu")
    public String saveProgramStudii(ProgramStudiu programStudiu){
        programStudiuService.saveProgramStudiu(programStudiu);
        return("redirect:/programStudiu_form");
    }
    @GetMapping("/programeStudii")
    public String programeStudii(Model model){
        List<ProgramStudiu> programeStudiu = programStudiuService.getProgrameStudiu();
        model.addAttribute("programeStudii",programeStudiu);
        return("programeStudii");
    }

}
