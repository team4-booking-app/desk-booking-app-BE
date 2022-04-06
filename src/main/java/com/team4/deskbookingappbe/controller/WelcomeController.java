package com.team4.deskbookingappbe.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

    @GetMapping("/welcome")
    public String Welcome(){
        return "BE WORKS! HELLO HEROKU.";
    }

}