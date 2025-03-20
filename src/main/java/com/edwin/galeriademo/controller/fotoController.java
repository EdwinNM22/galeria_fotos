package com.edwin.galeriademo.controller;

import com.edwin.galeriademo.model.foto;
import com.edwin.galeriademo.model.usuario;
import com.edwin.galeriademo.service.fotoService;
import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/fotos")
public class fotoController {

    private final Logger LOGGER = LoggerFactory.getLogger(fotoController.class);

    @Autowired
    private fotoService fotoService;

    @GetMapping("")
    public String show() {

        return "fotos/show";
    }

    @GetMapping("/create")
    public String create() {
    return "fotos/create";}

    @PostMapping("/save")
    public String save(foto foto) {
        LOGGER.info("Saving foto: {}", foto);
        usuario u= new usuario(1,"","","");
        foto.setUsuario(u);


        fotoService.save(foto);
        return "redirect:/fotos/";
    }
}
