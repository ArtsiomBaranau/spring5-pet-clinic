package com.gmail.artsiombaranau.spring5petclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class VetController {

    @RequestMapping({"/vets"})
    public String listOfVets() {
        return "vets/index";
    }
}