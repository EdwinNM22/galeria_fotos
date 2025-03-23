package com.edwin.galeriademo.controller;

import com.edwin.galeriademo.model.usuario;
import com.edwin.galeriademo.service.IUsuarioService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.logging.Logger;

@Controller
@RequestMapping("/usuario")
public class usuarioController {

    @Autowired
    private IUsuarioService usuarioService;

    @GetMapping("/registro")
    public String create() {
        return "usuario/registro";
    }

    @PostMapping("usuario/save")
    public String save(usuario usuario) {
        usuario.setTipo_usuario("USER");
        usuarioService.save(usuario);
        return "redirect:/";
    }
}
