package com.edwin.galeriademo.controller;


import org.springframework.ui.Model;
import com.edwin.galeriademo.model.foto;
import com.edwin.galeriademo.service.fotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/administrador")
public class administradorController {

    @Autowired
    private fotoService fotoService;

    @GetMapping("")
    public String home(Model model ) {

        List<foto> fotos = fotoService.findAll();
        model.addAttribute("fotos", fotos);
        return "administrador/home";

    }
}
