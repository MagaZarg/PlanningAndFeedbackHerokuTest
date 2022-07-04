package com.amotek.planningandfeedback.infrastructure.adapter.rest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HerokuController {

    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome to Spring app on Heroku";
    }

}
