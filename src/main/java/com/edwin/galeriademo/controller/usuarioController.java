package com.edwin.galeriademo.controller;

import com.edwin.galeriademo.model.usuario;
import com.edwin.galeriademo.service.IUsuarioService;
import jakarta.servlet.http.HttpSession;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;
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

    @PostMapping("/save")
    public String save(usuario usuario) {
        usuario.setTipo_usuario("USER");
        usuarioService.save(usuario);
        return "redirect:/usuario/login";
    }

    @GetMapping("/login")
    public String login() {
        return "usuario/login";
    }

    @PostMapping("/acceder")
    public String acceder(usuario usuario, HttpSession session) {
        Optional<usuario> user = usuarioService.findByEmail(usuario.getEmail());

        if (user.isPresent() && user.get().getPassword().equals(usuario.getPassword())) { // Asegúrate de que la contraseña se verifique
            session.setAttribute("idusuario", user.get().getId());

            if (user.get().getTipo_usuario().equals("ADMIN")) {
                return "redirect:/adm";
            } else {
                return "redirect:/";
            }
        } else {
            // Manejo de error: redirigir a la página de acceso con un mensaje de error
            return "redirect:/"; // Asegúrate de tener una página de login que maneje este parámetro
        }
    }
}

