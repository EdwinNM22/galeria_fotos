package com.edwin.galeriademo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/fotos")
public class fotoController {

    @GetMapping("")
    public String show() {

        return "fotos/show";
    }

    @GetMapping("/create")
    public String create() {
    return "fotos/create";}
}
