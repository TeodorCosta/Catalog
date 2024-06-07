package com.catalogApp.catalog.controller;


import com.catalogApp.catalog.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MainController {
    @Autowired
    StudentService studentService;



}
