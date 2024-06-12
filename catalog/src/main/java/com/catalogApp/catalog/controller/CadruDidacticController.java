package com.catalogApp.catalog.controller;


import com.catalogApp.catalog.entity.CadruDidactic;
import org.springframework.ui.Model;
import com.catalogApp.catalog.service.CadruDidacticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.UUID;

@Controller

public class CadruDidacticController {

    @Autowired
    CadruDidacticService cadruDidacticService;

    @GetMapping("/cadruDidactic_form")
    public String cadruDidacticForm(Model model) {

        model.addAttribute("cadruDidactic", new CadruDidactic());
        return "cadruDidactic-form";
    }

    @PostMapping("/save_cadruDidactic")
    public String savecadruDidactic(CadruDidactic cadruDidactic) {

        cadruDidacticService.saveCadruDidactic(cadruDidactic);

        return "redirect:/cadreDidactice";

    }

    @GetMapping("/cadreDidactice")
    public String cadreDidaactice(Model model) {

        List<CadruDidactic> cadreDidactice=cadruDidacticService.getcadreDidactice();
        model.addAttribute("cadreDidactice", cadreDidactice);
        return "cadreDidactice";

    }
    @GetMapping("/delete_cadruDidactic/{id}")
    public String delete_cadruDidactic(@PathVariable UUID id) {
        cadruDidacticService.delete_cadruDidactic(id);
        return("redirect:/cadreDidactice");
    }

    @GetMapping("/update_cadruDidactic/{id}")
    public String update_cadruDidactic(@PathVariable UUID id, Model model) {
        model.addAttribute("cadruDidactic",cadruDidacticService.getCadruDidacticById(id));
        return "cadruDidactic-form";
    }


}
