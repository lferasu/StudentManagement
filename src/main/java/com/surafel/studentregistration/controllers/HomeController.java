package com.surafel.studentregistration.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @GetMapping(value = {"/eregistrar", "/eregistrar/home","/"})
    public String showHome()
    {
        return "index";
    }
}
