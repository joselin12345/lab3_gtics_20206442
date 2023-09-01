package com.example.lab3_20206442.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping(name = "")
    public String inicio(){
        return "inicio";
    }

}
