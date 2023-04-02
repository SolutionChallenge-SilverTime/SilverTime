package com.solutionchallenge.entertainment.controller.dto;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TemplateController {

    @GetMapping("/home")
    public String homepage(){
        return "test";
    }

}
