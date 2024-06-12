package com.catalogApp.catalog.controller;


import com.catalogApp.catalog.entity.ProgramStudiu;
import com.catalogApp.catalog.service.ProgramStudiuService;
import com.catalogApp.catalog.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class MainController {
    @Autowired
    StudentService studentService;

    @Autowired
    ProgramStudiuService programStudiuService;

    @GetMapping("/home")
    public String index(){
        return"index";
    }
    @GetMapping("/nav")
    public String nav(){
        return"nav_bar";
    }
    @GetMapping("/dashboard")
    public String dashboard() {
        return "dashboard";
    }

    @GetMapping("/licente")
    public String licente(Model model){
        List<ProgramStudiu> programeStudiuIESC = programStudiuService.getProgrameStudiu().stream()
                .filter(programStudiu -> "IESC".equals(programStudiu.getFacultate()) && programStudiu.isLicenta())
                .collect(Collectors.toList());

        List<ProgramStudiu> programeStudiuDPM = programStudiuService.getProgrameStudiu().stream()
                .filter(programStudiu -> "DPM".equals(programStudiu.getFacultate()) && programStudiu.isLicenta())
                .collect(Collectors.toList());

        List<ProgramStudiu> programeStudiuMED = programStudiuService.getProgrameStudiu().stream()
                .filter(programStudiu -> "Med".equals(programStudiu.getFacultate()) && programStudiu.isLicenta())
                .collect(Collectors.toList());

        List<ProgramStudiu> programeStudiuECO = programStudiuService.getProgrameStudiu().stream()
                .filter(programStudiu -> "ECO".equals(programStudiu.getFacultate()) && programStudiu.isLicenta())
                .collect(Collectors.toList());

        List<ProgramStudiu> programeStudiuMuzica = programStudiuService.getProgrameStudiu().stream()
                .filter(programStudiu -> "Muzica".equals(programStudiu.getFacultate()) && programStudiu.isLicenta())
                .collect(Collectors.toList());
        model.addAttribute("programeStudiuIESC",programeStudiuIESC);
        model.addAttribute("programeStudiuDPM",programeStudiuDPM);
        model.addAttribute("programeStudiuMED",programeStudiuMED);
        model.addAttribute("programeStudiuECO",programeStudiuECO);
        model.addAttribute("programeStudiuMuzica",programeStudiuMuzica);
        return"licente";
    }

    @GetMapping("/masterate")
    public String masterate(Model model){
        List<ProgramStudiu> programeStudiuIESC = programStudiuService.getProgrameStudiu().stream()
                .filter(programStudiu -> "IESC".equals(programStudiu.getFacultate()) && !programStudiu.isLicenta())
                .collect(Collectors.toList());

        List<ProgramStudiu> programeStudiuDPM = programStudiuService.getProgrameStudiu().stream()
                .filter(programStudiu -> "DPM".equals(programStudiu.getFacultate()) && !programStudiu.isLicenta())
                .collect(Collectors.toList());

        List<ProgramStudiu> programeStudiuMED = programStudiuService.getProgrameStudiu().stream()
                .filter(programStudiu -> "Med".equals(programStudiu.getFacultate()) && !programStudiu.isLicenta())
                .collect(Collectors.toList());

        List<ProgramStudiu> programeStudiuECO = programStudiuService.getProgrameStudiu().stream()
                .filter(programStudiu -> "ECO".equals(programStudiu.getFacultate()) && !programStudiu.isLicenta())
                .collect(Collectors.toList());

        List<ProgramStudiu> programeStudiuMuzica = programStudiuService.getProgrameStudiu().stream()
                .filter(programStudiu -> "Muzica".equals(programStudiu.getFacultate()) && !programStudiu.isLicenta())
                .collect(Collectors.toList());
        model.addAttribute("programeStudiuIESC",programeStudiuIESC);
        model.addAttribute("programeStudiuDPM",programeStudiuDPM);
        model.addAttribute("programeStudiuMED",programeStudiuMED);
        model.addAttribute("programeStudiuECO",programeStudiuECO);
        model.addAttribute("programeStudiuMuzica",programeStudiuMuzica);
        return"masterate";
    }







}
