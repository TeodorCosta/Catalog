package com.catalogApp.catalog.controller;


import com.catalogApp.catalog.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @Autowired
    StudentService studentService;

    @GetMapping("/home")
    public String index(){
        return"index";
    }
    @GetMapping("/nav")
    public String nav(){
        return"nav_bar";
    }

    @GetMapping("/licente")
    public String licente(){
        return"licente";
    }







}
