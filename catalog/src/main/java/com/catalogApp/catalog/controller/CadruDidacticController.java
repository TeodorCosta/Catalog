package com.catalogApp.catalog.controller;


import com.catalogApp.catalog.entity.CadruDidactic;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import com.catalogApp.catalog.service.CadruDidacticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller

public class CadruDidacticController {

    @Autowired
    CadruDidacticService cadruDidacticService;

    @GetMapping("/cadruDidactic_form")
    public String cadruDidacticForm(Model model) {

        model.addAttribute("cadruDidactic", new CadruDidactic());
        return "cadruDidactic_form";
    }

    @PostMapping("save_cadruDidactic")
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
}
