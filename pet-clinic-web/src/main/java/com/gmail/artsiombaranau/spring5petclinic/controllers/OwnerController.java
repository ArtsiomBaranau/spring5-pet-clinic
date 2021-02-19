package com.gmail.artsiombaranau.spring5petclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OwnerController {

    @RequestMapping("/owners")
    public String listOfOwners() {
        return "owners/index";
    }
}
