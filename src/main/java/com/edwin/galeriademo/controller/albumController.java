package com.edwin.galeriademo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/albumes")
public class albumController {

    @GetMapping("")
    public String show() {
        return "albumes/show";
    }
}
