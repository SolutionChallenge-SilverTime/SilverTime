package com.solutionchallenge.entertainment.controller;

import com.solutionchallenge.entertainment.service.InterestService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/interest")
@RequiredArgsConstructor
@CrossOrigin("*")
public class InterestController {
    private final InterestService interestService;
    @GetMapping()
    String setInterest(){
        String[] strContents = {"Exercise", "Arts&Crafts", "Cooking", "Technology", "Culture", "History", "Language", "Communication", "Finance", "Music"};
        List<String> contents = new ArrayList<>(Arrays.asList(strContents));
        interestService.setInterest(contents);
        return "ok";
    }
}
